package com.haiyu.manager.service;

import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.pojo.Customer;

public interface CustomerService {
    Customer getInfoByOpenId(String openId);
}
