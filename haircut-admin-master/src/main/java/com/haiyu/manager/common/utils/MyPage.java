package com.haiyu.manager.common.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class MyPage<T> extends PageInfo<T> {
    private int code;
    private String Message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MyPage(List<T> list) {
        super(list, 8);
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
