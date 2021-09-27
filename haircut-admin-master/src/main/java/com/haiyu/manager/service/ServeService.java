package com.haiyu.manager.service;

import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.pojo.Serve;

import java.util.List;

public interface ServeService {
    List<Serve> listByStore(int sid);

    RestResult editServe(Serve serve);

    RestResult selectOne(int id);

    RestResult delete(int id);

    Integer selectCountBySid(int sid);
}
