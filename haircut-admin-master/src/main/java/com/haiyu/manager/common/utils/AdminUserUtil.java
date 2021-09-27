package com.haiyu.manager.common.utils;

import com.haiyu.manager.pojo.BaseAdminUser;
import org.apache.shiro.SecurityUtils;

import javax.security.auth.Subject;

public class AdminUserUtil {
    public static BaseAdminUser getUser(){
        return (BaseAdminUser) SecurityUtils.getSubject().getPrincipal();
    }
}
