package com.haiyu.manager.service;

import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.common.utils.MyPage;
import com.haiyu.manager.pojo.ServeOfBarber;

import java.util.List;

public interface ServeOfBarberService {

    MyPage selectBarberWithServeList(int sid, int id ,int pageNum, int pageSize);
}
