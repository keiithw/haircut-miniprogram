package com.haiyu.manager.service;

import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.pojo.WorkTime;

import java.util.List;

public interface WorkTimeService {
    RestResult create(WorkTime workTime);

    RestResult del(int id);

    List<WorkTime> getByParams(String start,  String end, int sid,int barberId);

    RestResult update(WorkTime workTime);
}
