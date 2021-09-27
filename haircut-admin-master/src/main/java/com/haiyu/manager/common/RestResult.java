package com.haiyu.manager.common;

import com.alibaba.fastjson.JSON;

public class RestResult {
    public void setCode(int code) {
        this.code = code;
    }

    private int code;//状态码

    private String msg = "";//消息

    private Object data;//数据

    public RestResult setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public RestResult setMsg(String message) {
        this.msg = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RestResult setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
