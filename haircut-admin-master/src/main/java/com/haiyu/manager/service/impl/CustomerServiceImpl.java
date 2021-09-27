package com.haiyu.manager.service.impl;

import com.haiyu.manager.dao.CustomerMapper;
import com.haiyu.manager.pojo.Customer;
import com.haiyu.manager.pojo.example.CustomerExample;
import com.haiyu.manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Customer getInfoByOpenId(String openId) {
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        criteria.andOpenIdEqualTo(openId);
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        if (!customers.isEmpty())
          return customers.get(0);
        return null;
    }
}
