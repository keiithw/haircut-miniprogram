package com.haiyu.manager.service.impl;

import com.haiyu.manager.common.R;
import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.dao.WorkTimeMapper;
import com.haiyu.manager.pojo.WorkTime;
import com.haiyu.manager.pojo.example.WorkTimeExample;
import com.haiyu.manager.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkTimeServiceImpl implements WorkTimeService {
    @Autowired
    private WorkTimeMapper workTimeMapper;

    @Override
    public RestResult create(WorkTime workTime) {
        if (workTime.getNoon()==1)
            workTime.setNoonName("上午");
        if (workTime.getNoon()==2)
            workTime.setNoonName("下午");
        if (workTime.getNoon()==3)
            workTime.setNoonName("夜间");
        if (workTime.getNoon()==5)
            workTime.setNoonName("全天");
        if (workTimeMapper.insertSelective(workTime)==1)
            return R.getSuccessResult();
        return R.getFailResult("插入失败");
    }

    @Override
    public RestResult del(int id) {
        if (workTimeMapper.deleteByPrimaryKey(id)==1)
            return R.getSuccessResult();
        return R.getFailResult("删除失败");
    }

    @Override
    public List<WorkTime> getByParams(String start, String end, int sid,int barberId)  {
            WorkTimeExample example = new WorkTimeExample();
            WorkTimeExample.Criteria criteria = example.createCriteria();
//            criteria.andSidEqualTo(sid);
            criteria.andStartBetween(start,end).andBarberIdEqualTo(barberId);
            List<WorkTime> workTimes = workTimeMapper.selectByExample(example);
            return workTimes;

    }

    @Override
    public RestResult update(WorkTime workTime) {
        if (workTimeMapper.updateByPrimaryKey(workTime)==1)
            return R.getSuccessResult();
        return R.getFailResult("删除失败");
    }
}
