package com.haiyu.manager.service;

import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.pojo.BaseAdminUser;
import com.haiyu.manager.dto.UserSearchDTO;
import com.haiyu.manager.pojo.MVPMember;
import com.haiyu.manager.response.PageDataResult;

import java.util.List;
import java.util.Map;


/**
 * @Title: AdminUserService
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/11/21 11:04
 */
public interface AdminUserService {

    List<BaseAdminUser> getAllStores();

    List<BaseAdminUser> listMembersInServe(int sid,int serveId);

    PageDataResult getUserList(UserSearchDTO userSearch, Integer pageNum, Integer pageSize);

    Map<String,Object> addUser(BaseAdminUser user);

    Map<String,Object> updateUser(BaseAdminUser user);

    BaseAdminUser getUserById(Integer id);

    BaseAdminUser findByUserName(String userName);

    int updatePwd(String userName,String password);

    Map<String, Object> delUser(Integer id,Integer status);

    Map<String, Object> recoverUser(Integer id,Integer status);

    List<BaseAdminUser> selectWholeStore(Integer sid);

    List<MVPMember> selectMVPMembers(Integer sid);
}
