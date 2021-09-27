package com.haiyu.manager.dao;

import com.haiyu.manager.dto.AdminUserDTO;
import com.haiyu.manager.dto.UserSearchDTO;
import com.haiyu.manager.pojo.BaseAdminUser;
import com.haiyu.manager.pojo.MVPMember;
import com.haiyu.manager.pojo.example.BaseAdminUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseAdminUserMapper {
    int countByExample(BaseAdminUserExample example);

    int deleteByExample(BaseAdminUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseAdminUser record);

    int insertSelective(BaseAdminUser record);

    List<BaseAdminUser> selectByExample(BaseAdminUserExample example);

    BaseAdminUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseAdminUser record, @Param("example") BaseAdminUserExample example);

    int updateByExample(@Param("record") BaseAdminUser record, @Param("example") BaseAdminUserExample example);

    int updateByPrimaryKeySelective(BaseAdminUser record);

    int updateByPrimaryKey(BaseAdminUser record);

    List<AdminUserDTO> getUserList(UserSearchDTO userSearch);

    BaseAdminUser getUserByUserName(String sysUserName, int id);

    int updateUser(BaseAdminUser user);

    int updateUserStatus(Integer id, Integer status);

    BaseAdminUser findByUserName(String userName);

    int updatePwd(String userName, String password);

    List<BaseAdminUser> listMemberInServe(@Param("sid") int sid,@Param("serveId") int serveId);

    List<MVPMember> selectMVPMembers(int sid);
}