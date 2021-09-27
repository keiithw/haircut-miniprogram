package com.haiyu.manager.service.impl;

import com.haiyu.manager.common.R;
import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.dao.StarMapper;
import com.haiyu.manager.pojo.BaseAdminUser;
import com.haiyu.manager.pojo.Star;
import com.haiyu.manager.pojo.example.StarExample;
import com.haiyu.manager.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class StarServiceImpl implements StarService {
    @Autowired
    private StarMapper starMapper;

    @Override
    public RestResult star(int customerId, int targetId, int isShop) {
        Star star = new Star(customerId,targetId,isShop,1,new Date());
        starMapper.insert(star);
        return R.getSuccessResult();
    }

    @Override
    public RestResult unstar(int customerId, int targetId) {
        List<Star> stars = getExistedStar(customerId, targetId);
        Integer id = stars.get(0).getId();
        starMapper.deleteByPrimaryKey(id);
        return R.getSuccessResult();
    }

    @Override
    public RestResult isStar(int customerId, int targetId) {
        List<Star> existedStar = getExistedStar(customerId, targetId);
        if (!existedStar.isEmpty())
            return R.getSuccessResult();
        else
            return R.getFailResult("未收藏");
    }

    private List<Star> getExistedStar(int customerId, int targetId) {
        StarExample example = new StarExample();
        example.createCriteria().andCustomerIdEqualTo(customerId).andTargetIdEqualTo(targetId);
        return starMapper.selectByExample(example);
    }

    @Override
    public List<BaseAdminUser> myStarShop(int customerId) {

        return null;
    }

    @Override
    public List<BaseAdminUser> myStarStylist(int customerId) {

        return null;
    }
}
