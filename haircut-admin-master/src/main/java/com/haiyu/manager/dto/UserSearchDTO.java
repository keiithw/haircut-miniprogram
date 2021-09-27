package com.haiyu.manager.dto;


import com.haiyu.manager.pojo.BaseAdminUser;
import lombok.Data;
import org.apache.shiro.SecurityUtils;

import java.util.Optional;

/**
 * @Title: UserSearchDTO
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/11/21 11:19
 */
@Data
public class UserSearchDTO {
    private String sysUserName;

    private String userPhone;

    private String startTime;

    private String endTime;

    private Integer sid;

    public UserSearchDTO(){
        BaseAdminUser principal = (BaseAdminUser) SecurityUtils.getSubject().getPrincipal();
        this.sid = Optional.ofNullable(principal.getSid()).orElseGet(()->-1);
    }
}
