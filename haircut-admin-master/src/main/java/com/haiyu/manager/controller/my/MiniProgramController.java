package com.haiyu.manager.controller.my;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.common.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.haiyu.manager.common.R;
import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.common.ResultCode;
import com.haiyu.manager.common.utils.*;
import com.haiyu.manager.config.DirectRabbitConfig;
import com.haiyu.manager.dao.AppointmentMapper;
import com.haiyu.manager.dao.CustomerMapper;
import com.haiyu.manager.dao.ReviewMapper;
import com.haiyu.manager.pojo.*;
import com.haiyu.manager.pojo.example.AppointmentExample;
import com.haiyu.manager.pojo.example.ReviewExample;
import com.haiyu.manager.service.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * openid	string	用户唯一标识
 * session_key	string	会话密钥
 * unionid	string	用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
 * errcode	number	错误码
 * errmsg	string	错误信息
 * errcode 的合法值
 * <p>
 * 值	说明	最低版本
 * -1	系统繁忙，此时请开发者稍候再试
 * 0	请求成功
 * 40029	code 无效
 * 45011	频率限制，每个用户每分钟100次
 *
 * @return
 */
@RequestMapping("wxApp")
@RestController
public class MiniProgramController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private OssUtils ossUtils;
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private ServeService serveService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private StarService starService;

    @Autowired
    private WorkTimeService workTimeService;
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private ReviewService reviewService;

    private final String APPID = "wx35edf82d0cd67686";
    private final String SECRET = "b5b6aafb8ad0ca13692cd51bcf54cbf0";
    private String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
//    private String ACCESS_TOKEN ;

    @GetMapping("review/storeReview")
    public RestResult getStoreReview(@RequestParam int sid) {
        List<Review> simpleReview = reviewMapper.getStoreReview(sid);
        if (!simpleReview.isEmpty())
            return R.getSuccessResult(simpleReview);
        else
            return R.getFailResult("没有数据");
    }

    @GetMapping("review/getById")
    public RestResult getById(@RequestParam int rid) {
        Review review = reviewMapper.selectByPrimaryKey(rid);
        List simpleReview = new ArrayList();
        simpleReview.add(review);
        if (!simpleReview.isEmpty())
            return R.getSuccessResult(simpleReview);
        else
            return R.getFailResult("没有数据");
    }

    @GetMapping("review/simpleReview")
    public RestResult getSimpleReview(@RequestParam int sid) {
        List<Review> simpleReview = reviewService.getSimpleReview(sid);
        if (!simpleReview.isEmpty())
            return R.getSuccessResult(simpleReview);
        else
            return R.getFailResult("没有数据");
    }

    @GetMapping("review/simpleBarberReview")
    public RestResult getSimpleBarberReview(@RequestParam int bid) {
        List<Review> simpleReview = reviewMapper.getSimpleBarberReview(bid);
        if (!simpleReview.isEmpty())
            return R.getSuccessResult(simpleReview);
        else
            return R.getFailResult(null);
    }

    @GetMapping("review/barberReview")
    public RestResult getBarberReview(@RequestParam int sid) {
        List<Review> simpleReview = reviewMapper.getBarberReview(sid);
        if (!simpleReview.isEmpty())
            return R.getSuccessResult(simpleReview);
        else
            return R.getFailResult(null);
    }

    @PostMapping("/review/create")
    public RestResult createReview(@RequestBody Review review) {
        Integer aid = review.getAid();

        review.setDate(new Date());
        int insert = reviewMapper.insert(review);

        Appointment appointment = new Appointment();
        appointment.setIsReview(1);
        appointment.setAid(aid);
        appointment.setRid(review.getRid());
        appointmentMapper.updateByPrimaryKeySelective(appointment);
        return R.getSuccessResult();
    }

    @GetMapping("appointment/myAppointments")
    public RestResult myAppointments(@RequestParam int myId) {
        AppointmentExample example = new AppointmentExample();
        example.createCriteria().andCustomerIdEqualTo(myId);
        List<Appointment> appointments = appointmentMapper.selectByExample(example);
        appointments.stream()
                .forEach(a -> {
                    if (a.getStatus() == -1 || a.getStatus() == 1)
                        a.setNumber(appointmentMapper.selectEarlierApm(a.getBarberId(), a.getDay()));
                });
        System.out.println(appointments);
        return R.getSuccessResult(appointments);
    }

    @PostMapping("appointment/pay")
    public RestResult payAppointment(@RequestBody Appointment appointment) {
        //todo 获取手机
        String customerPhone = appointment.getCustomerPhone();
        appointment.setStatus(2);
        appointmentMapper.updateByPrimaryKeySelective(appointment);
        return R.getSuccessResult();
    }

    @PostMapping("appointment/edit")
    public RestResult editAppointment(@RequestBody Appointment appointment) {
        return null;
    }

    @GetMapping("appointment/cancel")
    public RestResult cancelAppointment(@RequestParam int id) {
        return appointmentService.cancel(id);
    }


    @PostMapping("appointment/checkBusy")
    public RestResult checkIsAppointmentBusy(@RequestBody Appointment appointment) {
        String advice = "";
        int full = 0;
        Date day = appointment.getDay();
        Date startTime = getStartTime(day);
        Date endTime = getEndTime(day);
        Map<String, Object> resMap = new HashMap<>();
        Integer max = appointment.getMax();
        int segment = getSegment(day);
        AppointmentExample example = new AppointmentExample();
        example.createCriteria().andSegmentBetween(segment - 1, segment + 1).andBarberIdEqualTo(appointment.getBarberId()).andDayBetween(startTime, endTime);
        List<Appointment> appointments = appointmentMapper.selectByExample(example);
        int size = appointments.size();
        if (size == 0) {
            advice = "wow！当前没有人预约这个时段！这是你独享的moment, 赶紧预约吧！";
        } else if (size < max * 0.5) {
            advice = "已有" + size + "个人预约这时段,比较空闲~ 适合预约.";
        } else if (size < max) {
            advice = "已有" + size + "个人预约这时段,ta有点忙~ 换个时间或者换个ta看看吧.";
        } else if (size >= max) {
            advice = "此时段预约ta的人数已满" + size + "人！换个时间或者换个ta看看吧.";
            full = 1;
        }
        resMap.put("size", size);
        resMap.put("max", max);
        resMap.put("advice", advice);
        resMap.put("full", full);
        return R.getSuccessResult(resMap);
    }

    @PostMapping("appointment/save")
    public RestResult saveAppointment(@RequestBody Appointment appointment) {
        int f;
        pushTimeToStd(appointment);
        try {
            boolean flag;
            /**
             * 前端根据哪个页面跳转来标识（insert）更新还是插入。
             *     ---插入
             *     -获取redis锁
             *      ---获取成功 1.检查是否还有剩余
             *                ---有剩余   -插入数据
             *                ---没有剩余 -返回状态码
             *                2.释放锁
             *     ---更新
             */
            if (appointment.getAid() == null) {
                //获取分布式锁
                flag = redisUtil.setnx(String.format(RedisUtil.APPOINT_LOCK_FORMATE, appointment.getBarberId(),
                        appointment.getSegment()), "locking", 3, TimeUnit.SECONDS);
                if (flag) {
                    //获取成功，检查时同一间段是否还有剩余位置
                    if (noMoreVacancy(appointment)) return R.getFreeResult(ResultCode.APPOINTMENT_FULL, "时段被抢完了", null);
                } else {
                    //没拿到锁，重试
                    while (!flag) {
                        try {
                            Thread.sleep(100);
                            flag = redisUtil.setnx(String.format(RedisUtil.APPOINT_LOCK_FORMATE, appointment.getBarberId(),
                                    appointment.getSegment()), "locking", 2, TimeUnit.SECONDS);
                            if (flag) {
                                if (noMoreVacancy(appointment))
                                    return R.getFreeResult(ResultCode.APPOINTMENT_FULL, "时段被抢完了", null);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                appointment.setCreatedTime(new Date());
                f = appointmentMapper.insertSelective(appointment);

                if (f==1){
                    Map<String,String> smsParm = new HashMap<>();
                    smsParm.put("phone",appointment.getCustomerPhone());
                    smsParm.put("storeName",appointment.getStoreName());
                    smsParm.put("day",DateUtils.getFormatTime(appointment.getDay(), "yyyy-MM-dd HH:mm:ss"));
                    smsParm.put("serveName",appointment.getServerName());
                    rabbitTemplate.convertAndSend(DirectRabbitConfig.TEST_DIRECT_EXCHANGE,DirectRabbitConfig.TEST_DIRECT_ROUTING,smsParm);
                }

            } else {
                f = appointmentMapper.updateByPrimaryKeySelective(appointment);
            }

        } finally {
            redisUtil.del(String.format(RedisUtil.APPOINT_LOCK_FORMATE, appointment.getBarberId(),
                    appointment.getSegment()));
        }


        return f == 0 ? R.getFailResult("更新失败") : R.getSuccessResult();
    }

    public boolean noMoreVacancy(@RequestBody Appointment appointment) {
        RestResult restResult = checkIsAppointmentBusy(appointment);
        Map<String, Integer> data = (Map) restResult.getData();
        if (data.get("size").equals(data.get("max"))) {
            return true;
        }
        return false;
    }


    public Date getStartTime(Date day) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(day);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }


    public Date getEndTime(Date day) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(day);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }


    private void pushTimeToStd(@RequestBody Appointment appointment) {
        Date day = appointment.getDay();
        int segment = getSegment(day);
        int minutes = day.getMinutes();
        if (minutes >= 0 && minutes <= 15)
            day.setMinutes(0);
        else if (minutes <= 45)
            day.setMinutes(30);
        else if (minutes < 60) {
            int hours = day.getHours();
            day.setHours(hours + 1);
            day.setMinutes(0);
        }
        appointment.setSegment(segment);
    }

    @GetMapping("/idGenerate")
    public Integer idGenerate(@RequestParam int customerId, HttpServletRequest request) {
        long l = System.currentTimeMillis();
        String s = l + customerId + request.getRemoteAddr();
        int i = s.hashCode();
        System.out.println(i);
        return i;
    }

    private int getSegment(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        return calendar.get(Calendar.HOUR_OF_DAY) * 2 + calendar.get(Calendar.MINUTE) / 30 + 1;
    }


    @GetMapping("/listServer")
    public MyPage listServers(@RequestParam(defaultValue = "1", required = false) int pageNum,
                              @RequestParam(defaultValue = "20", required = false) int pageSize,
                              @RequestParam int sid) {
        PageHelper.startPage(pageNum, pageSize);
        Object a = null;
        List<Serve> serves = serveService.listByStore(sid);
        MyPage myPage = new MyPage(serves);
        myPage.setCode(200);
        return myPage;
    }

    @GetMapping("getAccessToken")
    public String getAccessToken() {
        String object = restTemplate.getForObject(String.format(accessTokenUrl, APPID, SECRET), String.class);
        JSONObject jsonObject = JSON.parseObject(object);
        return jsonObject.get("access_token").toString();
    }


    //获取工作者的工作时间
    @GetMapping("calendar/getByParams")
    public List<WorkTime> getByParams(@RequestParam String start, @RequestParam String end, @RequestParam int barberId) {
        //sid已经失效
        List<WorkTime> list = workTimeService.getByParams(start, end, 0, barberId);
        List<WorkTime> workTimes = list.stream().filter(s -> s.getTitle().equals("工作")).collect(Collectors.toList());
        return workTimes;
    }

    @GetMapping("listMembersInServe")
    public RestResult listMembersInServe(@RequestParam int sid, @RequestParam int serveId) {
        List<BaseAdminUser> baseAdminUsers = adminUserService.listMembersInServe(sid, serveId);
//        baseAdminUsers.stream().forEach(s->{
//            Double barberMark = reviewMapper.getBarberMark(s.getId());
//            s.setMark(barberMark ==null?5:barberMark);
//            if (redisUtil.hasKey(String.format(RedisUtil.ONLINE_KEY_FORMATE,s.getId())))
//                s.setWorking(1);
//            else s.setWorking(0);
//        });
        for (BaseAdminUser s : baseAdminUsers
        ) {
            Double barberMark = reviewMapper.getBarberMark(s.getId());
            s.setMark(barberMark == null ? 5 : barberMark);
            if (redisUtil.hasKey(String.format(RedisUtil.ONLINE_KEY_FORMATE, s.getId())))
                s.setWorking(1);
            else s.setWorking(0);
        }
        return R.getSuccessResult(baseAdminUsers);
    }

    @GetMapping("/sysUser/listStore")
    public RestResult listStore(
            @RequestParam String longitude,
            @RequestParam String latitude) {
        double v = Double.parseDouble(longitude);
        double v1 = Double.parseDouble(latitude);
        List<BaseAdminUser> collect = listStore(v, v1);
        return R.getSuccessResult(collect);
    }


    @PostMapping("customer/setInfo")
    public RestResult setInfo(@RequestBody Customer customer) {
        if (customer.getId() != 0) {
            customer.setFinishInfo(1);
            customerMapper.updateByPrimaryKeySelective(customer);
        } else {
            SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils();
            int id = (int) snowflakeIdUtils.nextId();
            customer.setId(id);
            customer.setFinishInfo(1);
            customer.setCreatedTime(new Date());
            customer.setType(1);
            customerMapper.insertSelective(customer);
        }
        return R.getSuccessResult(customer);
    }


    @PostMapping("login")
    public RestResult login(String code, String encryptedData, String iv) {
        String targetUrl = String.format("https://api.weixin.qq.com/sns/jscode2session" +
                "?appid=%s&" +
                "secret=%s&" +
                "js_code=%s&" +
                "grant_type=authorization_code", APPID, SECRET, code);
        String loginResult = restTemplate.getForObject(targetUrl, String.class);
        JSONObject jsonObject = JSON.parseObject(loginResult);
        System.out.println(jsonObject);
        //获取会话密钥（session_key）
        String session_key = jsonObject.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) jsonObject.get("openid");
        Customer customer = customerService.getInfoByOpenId(openid);
        Optional<Customer> optional = Optional.ofNullable(customer);
        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
            String result = AesUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                JSONObject userInfoJSON = JSONObject.parseObject(result);
                System.out.println("infoJson:" + userInfoJSON);
                initJsonObj(jsonObject, optional, userInfoJSON);
                return R.getSuccessResult(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.getFailResult("解密失败");
    }


    @PostMapping("star")
    public RestResult star(@RequestBody Star star) {
        Integer customerId = star.getCustomerId();
        Integer targetId = star.getTargetId();
        Integer isShop = star.getIsShop();
        return starService.star(customerId, targetId, isShop);
    }

    @PostMapping("unstar")
    public RestResult unstar(@RequestBody Star star) {
        Integer customerId = star.getCustomerId();
        Integer targetId = star.getTargetId();
        return starService.unstar(customerId, targetId);
    }

    @PostMapping("isStar")
    public RestResult isStar(@RequestBody Star star) {
        Integer customerId = star.getCustomerId();
        Integer targetId = star.getTargetId();
        return starService.isStar(customerId, targetId);
    }

    @PostMapping("/uploadPhoto")
    @ResponseBody
    public Map<String, Object> uploadPhoto(@RequestParam("file") MultipartFile file) throws IOException {
//        String s = UploadUtil.singFile(file, UUID.randomUUID().toString(), "static/upload/");
        String dangerUrl = ossUtils.checkImage(file);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "上传成功");
        String url = dangerUrl.substring(0, dangerUrl.indexOf("?"));
        map.put("path", url);
        return map;
    }

    public void initJsonObj(JSONObject jsonObject, Optional<Customer> optional, JSONObject userInfoJSON) {
        jsonObject.put("nickName", userInfoJSON.get("nickName"));
        jsonObject.put("gender", userInfoJSON.get("gender"));
        jsonObject.put("city", userInfoJSON.get("city"));
        jsonObject.put("province", userInfoJSON.get("province"));
        jsonObject.put("country", userInfoJSON.get("country"));
        jsonObject.put("avatarUrl", userInfoJSON.get("avatarUrl"));
        jsonObject.put("phone", optional.map(Customer::getPhone).orElseGet(() -> ""));
        jsonObject.put("birthday", optional.map(Customer::getBirthday).orElseGet(Date::new));
        jsonObject.put("height", optional.map(Customer::getHeight).orElseGet(() -> 0));
        jsonObject.put("weight", optional.map(Customer::getWeight).orElseGet(() -> 0));
        jsonObject.put("introduce", optional.map(Customer::getIntroduce).orElse(""));
        jsonObject.put("finishInfo", optional.map(Customer::getFinishInfo).orElseGet(() -> 0));
        jsonObject.put("id", optional.map(Customer::getId).orElseGet(() -> 0));
    }

    private List<BaseAdminUser> listStore(double v, double v1) {
        List<BaseAdminUser> allStores = adminUserService.getAllStores();
        List<BaseAdminUser> collect = allStores.stream().sorted(Comparator.comparing(s -> s.getDistance(v1, v)))
                .limit(15).collect(Collectors.toList());
        collect.forEach(s -> {
            Integer sid = s.getSid();
            s.setDistance(String.format("%.2f", s.getDistance(v1, v) / 1000));
            s.setQueue(reviewMapper.getQueuedNumber(sid));
            Double avgPrice = appointmentMapper.getAvgPrice(sid);
            s.setPrice(avgPrice == null ? 10 : avgPrice);
            Double storeMark = reviewMapper.getStoreMark(sid);
            s.setMark(storeMark == null ? 5.0 : storeMark);
        });
        return collect;
    }
}
