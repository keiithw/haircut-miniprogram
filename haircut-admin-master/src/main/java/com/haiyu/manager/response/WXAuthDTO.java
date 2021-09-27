package com.haiyu.manager.response;

import lombok.Data;

@Data
public class WXAuthDTO {
    private String openid;
    private String session_key;
    private String unionid;
    private String errmsg;
    private Integer errcode;
}
