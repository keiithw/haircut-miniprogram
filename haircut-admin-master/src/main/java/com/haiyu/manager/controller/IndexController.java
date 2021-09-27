package com.haiyu.manager.controller;

import com.alibaba.fastjson.JSON;
import com.haiyu.manager.common.utils.AdminUserUtil;
import com.haiyu.manager.dao.BaseAdminUserMapper;
import com.haiyu.manager.pojo.BaseAdminUser;
import com.haiyu.manager.pojo.MVPMember;
import com.haiyu.manager.pojo.Review;
import com.haiyu.manager.pojo.Serve;
import com.haiyu.manager.pojo.example.BaseAdminUserExample;
import com.haiyu.manager.service.AdminUserService;
import com.haiyu.manager.service.AppointmentService;
import com.haiyu.manager.service.ReviewService;
import com.haiyu.manager.service.ServeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * @Title: LoginController
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/11/20 11:39
 */
@Controller
public class IndexController {

    @Autowired
    private BaseAdminUserMapper baseAdminUserMapper;
    @Autowired
    private ServeService serveService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private AdminUserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("login")
    public String tologin(){
        logger.info("定向登陆页");
        return "login-1";
    }

    @RequestMapping("home")
    public ModelAndView home(ModelAndView mav){
        logger.info("定向主页");
        BaseAdminUser user = AdminUserUtil.getUser();
        Integer sid = user.getSid();
        Integer serveCount = serveService.selectCountBySid(sid);
        Integer totalIncome = appointmentService.totalIncome(sid);
        Integer waitingApm = appointmentService.countWaitingApmBySid(sid);
        Integer reviewCount = reviewService.countBySid(sid);
        List<MVPMember> mvpMembers = userService.selectMVPMembers(sid);
        List<Review> reviewList = reviewService.getLatest5(sid);

        mav.addObject("serveCount",serveCount);
        mav.addObject("totalIncome",totalIncome);
        mav.addObject("waitingApm",waitingApm);
        mav.addObject("reviewCount",reviewCount);
        mav.addObject("reviewList",reviewList);
        mav.addObject("mvpMembers",mvpMembers);
        mav.setViewName("home");
        return mav;
    }


    @RequestMapping("logout")
    public String logout(){
        logger.info("退出系统");
        Subject subject = SecurityUtils.getSubject();
        subject.logout(); // shiro底层删除session的会话信息
        return "redirect:login";
    }

    @RequestMapping("serveManage")
    public ModelAndView serverManage(ModelAndView modelAndView){
        logger.info("定向服务");
        BaseAdminUser user = AdminUserUtil.getUser();
        modelAndView.addObject("sid",user.getSid());
        modelAndView.setViewName("serve/serveManage");
        return modelAndView;
    }

    @RequestMapping("manageServeOfTony")
    public ModelAndView manageServeOfTony(ModelAndView modelAndView){
        logger.info("定向Tony的服务设置");
        BaseAdminUser user = AdminUserUtil.getUser();
        modelAndView.addObject("sid",user.getSid());
        modelAndView.addObject("uid",user.getId());
        modelAndView.setViewName("serve/manageServeOfTony");
        return modelAndView;
    }

    @RequestMapping("appointmentManage")
    public ModelAndView appointmentManage(ModelAndView mav){
        logger.info("定向Tony的服务设置");
        BaseAdminUser principal = (BaseAdminUser) SecurityUtils.getSubject().getPrincipal();
        Integer roleId = principal.getRoleId();
        List<BaseAdminUser> stuffsInStore = getStuffsInStore(principal.getSid());
        Map<String,Object> userMap = new HashMap<>();

        Map<String,Integer> statusMap = new HashMap<>();
        statusMap.put("已预约",-1);
        statusMap.put("服务中",1);
        statusMap.put("已完成",2);
        statusMap.put("已失效",3);

        userMap.put("roleId",roleId);
        userMap.put("status",JSON.toJSON(statusMap));
        userMap.put("stuffs", JSON.toJSON(stuffsInStore));
        userMap.put("sid", Optional.ofNullable(principal.getSid()).orElse(-1));
        mav.setViewName("/appointment/appointmentManage");
        mav.addObject("userMap",userMap);
        return mav;
    }

    @RequestMapping("reviewManagement")
    public ModelAndView reviewManagement(ModelAndView mav){
        logger.info("定向Tony的服务设置");
        BaseAdminUser principal = (BaseAdminUser) SecurityUtils.getSubject().getPrincipal();
        Integer roleId = principal.getRoleId();
        Integer sid = principal.getSid();
        List<BaseAdminUser> stuffsInStore = getStuffsInStore(sid);
        Map<String,Object> userMap = new HashMap<>();

        List<Serve> serves = serveService.listByStore(sid);

        userMap.put("roleId",roleId);
        userMap.put("serveName",JSON.toJSON(serves));
        userMap.put("stuffs", JSON.toJSON(stuffsInStore));
        userMap.put("sid", Optional.ofNullable(sid).orElse(-1));
        mav.setViewName("/review/reviewManagement");
        mav.addObject("userMap",userMap);
        return mav;
    }

    @GetMapping("fullcalendar")
    public ModelAndView goFullcalendar(ModelAndView modelAndView){
        logger.info("定向日历");
        BaseAdminUser user = AdminUserUtil.getUser();
        Integer sid = user.getSid();
        Integer roleId = user.getRoleId();
        List<BaseAdminUser> baseAdminUsers = getStuffsInStore(sid);
        if (roleId==1||roleId==2||roleId==9)
            modelAndView.addObject("isGranted",1);
        else
            modelAndView.addObject("isGranted",0);
        modelAndView.addObject("stuffs",baseAdminUsers);
        modelAndView.addObject("sid",sid);
        modelAndView.setViewName("fullcalendar");
        return modelAndView;
    }

    private List<BaseAdminUser> getStuffsInStore(Integer sid) {
        BaseAdminUserExample example = new BaseAdminUserExample();
        BaseAdminUserExample.Criteria criteria = example.createCriteria();
        criteria.andSidEqualTo(sid);
        criteria.andIsShopNotEqualTo(1);
        return baseAdminUserMapper.selectByExample(example);
    }
}
