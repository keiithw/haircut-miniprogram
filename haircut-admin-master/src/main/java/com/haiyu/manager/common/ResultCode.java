package com.haiyu.manager.common;

public enum ResultCode {
    SUCCESS(200),//成功
    FAIL(0),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500),//服务器内部错误
    APPOINTMENT_FULL(999);

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

    public int getCode() {
        return code;
    }
}
