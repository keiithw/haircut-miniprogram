package com.haiyu.manager.controller.system;

import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.common.utils.AdminUserUtil;
import com.haiyu.manager.common.utils.OssUtils;
import com.haiyu.manager.common.utils.RedisUtil;
import com.haiyu.manager.common.utils.UploadUtil;
import com.haiyu.manager.dto.LoginDTO;
import com.haiyu.manager.dto.UserSearchDTO;
import com.haiyu.manager.pojo.BaseAdminUser;
import com.haiyu.manager.response.PageDataResult;
import com.haiyu.manager.service.AdminUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Title: UserController
 * @Description: 系统用户管理
 * @author: wu
 * @version: 1.0
 * @date: 2018/11/20 15:17
 */
@Controller
@RequestMapping("user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private OssUtils ossUtils;
    @Autowired
    private RedisUtil redisUtil;

    private final String ONLINE_KEY_FORMAT = "ONLINE:%s";

    /**
     * 默认5小时有效
     * @return
     */
    @GetMapping("online")
    @ResponseBody
    public int online(@RequestParam int userId){
        redisUtil.set(String.format(ONLINE_KEY_FORMAT,userId), 1, 18000);
        return 1;
    }

    @GetMapping("isOnline")
    @ResponseBody
    public int isOnline(@RequestParam int userId){
        Object o = redisUtil.get(String.format(ONLINE_KEY_FORMAT, userId));
        if (o!=null)
            return 1;
        return 0;
    }

    @GetMapping("offline")
    @ResponseBody
    public int offline(@RequestParam int userId){
        redisUtil.del(String.format(ONLINE_KEY_FORMAT,userId));
        return 1;
    }


    @GetMapping("closeStore")
    @ResponseBody
    public int closeStore(@RequestParam int sid){
        List<BaseAdminUser> baseAdminUsers = adminUserService.selectWholeStore(sid);
        baseAdminUsers.forEach(u->redisUtil.del(String.format(ONLINE_KEY_FORMAT,u.getId())));
        return 1;
    }


    /**
     *
     * 功能描述: 登入系统
     *
     * @param:
     * @return:
     * @auther: wu
     * @date: 2018/11/22 15:47
     */
    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, LoginDTO loginDTO, HttpSession session){
        logger.info("进行登陆");
        Map<String,Object> data = new HashMap();
        // 使用 shiro 进行登录
        Subject subject = SecurityUtils.getSubject();
        String userName = loginDTO.getUsername().trim();
        String password = loginDTO.getPassword().trim();
        String rememberMe = loginDTO.getRememberMe();
        String host = request.getRemoteAddr();

        //获取token
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password,host);

        // 设置 remenmberMe 的功能
        if (rememberMe != null && rememberMe.equals("on")) {
            token.setRememberMe(true);
        }

        try {
            subject.login(token);
            // 登录成功
            BaseAdminUser user = (BaseAdminUser) subject.getPrincipal();
            data.put("code",1);
            data.put("url","/home");
            //data.put("message","登陆成功");
            logger.info(user.getSysUserName()+"登陆成功");

        } catch (UnknownAccountException e) {
            data.put("code",0);
            data.put("message",userName+"账号不存在");
            logger.error(userName+"账号不存在");
            return data;
        }catch (DisabledAccountException e){
            data.put("code",0);
            data.put("message",userName+"账号异常");
            logger.error(userName+"账号异常");
            return data;
        }
        catch (AuthenticationException e){
            data.put("code",0);
            data.put("message",userName+"密码错误");
            logger.error(userName+"密码错误");
            return data;
        }

        return data;
    }

    /**
     *
     * 功能描述: 修改密码
     *
     * @param:
     * @return:
     * @auther: wu
     * @date: 2018/11/22 17:26
     */
    @RequestMapping("setPwd")
    @ResponseBody
    public Map<String,Object> setP(String pwd, String isPwd){
        logger.info("进行密码重置");
        Map<String,Object> data = new HashMap();
        if(!pwd.equals(isPwd)){
            data.put("code",0);
            data.put("message","两次输入的密码不一致!");
            logger.error("两次输入的密码不一致!");
            return data;
        }
        //获取当前登陆的用户信息
        BaseAdminUser user = (BaseAdminUser) SecurityUtils.getSubject().getPrincipal();
        int result = adminUserService.updatePwd(user.getSysUserName(),pwd);
        if(result == 0){
            data.put("code",0);
            data.put("msg","修改密码失败！");
            logger.error("用户修改密码失败！");
            return data;
        }
        data.put("code",1);
        data.put("msg","修改密码成功！");
        logger.info("用户修改密码成功！");
        return data;
    }

    @GetMapping("id")
    @ResponseBody
    public int getId(){
        BaseAdminUser user = AdminUserUtil.getUser();
        return Optional.ofNullable(user.getId()).orElse(-1);
    }

    @PostMapping("uploadPhoto")
    @ResponseBody
    public Map<String,Object> uploadPhoto(@RequestParam("file") MultipartFile file) throws IOException{
//        String s = UploadUtil.singFile(file, UUID.randomUUID().toString(), "static/upload/");
        String dangerUrl = ossUtils.checkImage(file);
        Map<String, Object> map=new HashMap<>();
        map.put("code", 1);
        map.put("message","上传成功");
        String url = dangerUrl.substring(0,dangerUrl.indexOf("?"));
        map.put("path",url);
        return map;
    }
    /**
     *
     * 功能描述: 跳到系统用户列表
     *
     * @param:
     * @return:
     * @auther: wu
     * @date: 2018/11/21 13:50
     */
    @RequestMapping("/userManage")
    public ModelAndView userManage(ModelAndView mav) {
        BaseAdminUser principal = (BaseAdminUser) SecurityUtils.getSubject().getPrincipal();
        Integer roleId = principal.getRoleId();
        Map<String,Object> userMap = new HashMap<>();
        userMap.put("roleId",roleId);
        userMap.put("sid", Optional.ofNullable(principal.getSid()).orElse(-1));
        mav.setViewName("/user/userManage");
        mav.addObject("userMap",userMap);
        return mav;
    }

    /**
     *
     * 功能描述: 分页查询用户列表
     *
     * @param:
     * @return:
     * @auther: wu
     * @date: 2018/11/21 11:10
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getUserList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,/*@Valid PageRequest page,*/ UserSearchDTO userSearch) {
        /*logger.info("分页查询用户列表！搜索条件：userSearch：" + userSearch + ",pageNum:" + page.getPageNum()
                + ",每页记录数量pageSize:" + page.getPageSize());*/
        PageDataResult pdr = new PageDataResult();

        try {
            // 获取用户列表
            pdr = adminUserService.getUserList(userSearch, pageNum ,pageSize);
            logger.info("用户列表查询=pdr:" + pdr);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户列表查询异常！", e);
        }
        return pdr;
    }


    /**
     *
     * 功能描述: 新增和更新系统用户
     *
     * @param:
     * @return:
     * @auther: wu
     * @date: 2018/11/22 10:14
     */
    @RequestMapping(value = "/setUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> setUser(BaseAdminUser user) {
        logger.info("设置用户[新增或更新]！user:" + user);
        Map<String,Object> data = new HashMap();
        if(user.getId() == null){
            data = adminUserService.addUser(user);
        }else{
            data = adminUserService.updateUser(user);
        }
       return data;
    }


    /**
     *
     * 功能描述: 删除/恢复 用户
     *
     * @param:
     * @return:
     * @auther: wu
     * @date: 2018/11/22 11:59
     */
    @RequestMapping(value = "/updateUserStatus", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUserStatus(@RequestParam("id") Integer id,@RequestParam("status") Integer status) {
        logger.info("删除/恢复用户！id:" + id+" status:"+status);
        Map<String, Object> data = new HashMap<>();
        if(status == 0){
            //删除用户
            data = adminUserService.delUser(id,status);
        }else{
            //恢复用户
            data = adminUserService.recoverUser(id,status);
        }
        return data;
    }


}
