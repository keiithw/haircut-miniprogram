package com.haiyu.manager.service;

import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.pojo.BaseAdminUser;

import java.util.List;

public interface StarService {
    RestResult star(int customerId,int targetId,int isShop);

    RestResult unstar(int customerId,int targetId);

    RestResult isStar(int customerId,int targetId);

    List<BaseAdminUser> myStarShop(int customerId);

    List<BaseAdminUser> myStarStylist(int customerId);
}
