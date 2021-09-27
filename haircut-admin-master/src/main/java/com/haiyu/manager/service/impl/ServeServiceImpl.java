package com.haiyu.manager.service.impl;

import com.haiyu.manager.common.R;
import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.pojo.example.ServeExample;
import com.haiyu.manager.dao.ServeMapper;
import com.haiyu.manager.pojo.Serve;
import com.haiyu.manager.service.ServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServeServiceImpl implements ServeService {

    @Autowired
    private ServeMapper serveMapper;

    @Override
    public List<Serve> listByStore(int sid) {
        ServeExample serveExample = new ServeExample();
        ServeExample.Criteria criteria = serveExample.createCriteria();
        criteria.andSidEqualTo(sid);
        List<Serve> serves = serveMapper.selectByExample(serveExample);
        return serves;
    }

    @Override
    public RestResult editServe(Serve serve) {
        ServeExample serveExample = new ServeExample();
        ServeExample.Criteria criteria = serveExample.createCriteria();
        criteria.andIdEqualTo(serve.getId());
        return serveMapper.updateByExampleSelective(serve, serveExample)==1? R.getSuccessResult():R.getFailResult("更新失败");
    }

    @Override
    public RestResult selectOne(int id) {
        ServeExample serveExample = new ServeExample();
        ServeExample.Criteria criteria = serveExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<Serve> serves = serveMapper.selectByExample(serveExample);
        return R.getSuccessResult(serves);
    }



    @Override
    public RestResult delete(int id) {
        ServeExample serveExample = new ServeExample();
        ServeExample.Criteria criteria = serveExample.createCriteria();
        criteria.andIdEqualTo(id);
        return R.getSuccessResult(serveMapper.deleteByExample(serveExample));
    }

    @Override
    public Integer selectCountBySid(int sid) {
        ServeExample example = new ServeExample();
        example.createCriteria().andSidEqualTo(sid);
        int i = serveMapper.countByExample(example);
        return i;
    }
}
