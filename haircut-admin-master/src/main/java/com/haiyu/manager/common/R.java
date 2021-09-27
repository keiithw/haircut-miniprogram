package com.haiyu.manager.common;

import org.springframework.stereotype.Component;

@Component
public class R extends RestResult {
    private static final String SUCCESS = "操作成功";
    RestResult restResult=new RestResult();

    //成功
    public static RestResult getSuccessResult() {
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMsg(SUCCESS);
    }
    //成功，附带额外数据
    public static RestResult getSuccessResult(Object data) {
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMsg(SUCCESS)
                .setData(data);
    }

    //成功，自定义消息及数据
    public static RestResult getSuccessResult(String message,Object data) {
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMsg(message)
                .setData(data);
    }
    //失败，附带消息
    public static RestResult getFailResult(String message) {
        return new RestResult()
                .setCode(ResultCode.FAIL)
                .setMsg(message);
    }
    //失败，自定义消息及数据
    public static RestResult getFailResult(String message, Object data) {
        return new RestResult()
                .setCode(ResultCode.FAIL)
                .setMsg(message)
                .setData(data);
    }
    //自定义创建
    public static RestResult getFreeResult(ResultCode code, String message, Object data) {
        return new RestResult()
                .setCode(code)
                .setMsg(message)
                .setData(data);
    }
}

