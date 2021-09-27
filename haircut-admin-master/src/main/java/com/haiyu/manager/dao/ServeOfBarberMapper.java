package com.haiyu.manager.dao;

import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.pojo.ServeOfBarber;
import com.haiyu.manager.pojo.example.ServeOfBarberExample;
import java.util.List;

import com.haiyu.manager.response.ServeOfBarberResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServeOfBarberMapper {
    int countByExample(ServeOfBarberExample example);

    int deleteByExample(ServeOfBarberExample example);

    int insert(ServeOfBarber record);

    int insertSelective(ServeOfBarber record);

    List<ServeOfBarber> selectByExample(ServeOfBarberExample example);

    int updateByExampleSelective(@Param("record") ServeOfBarber record, @Param("example") ServeOfBarberExample example);

    int updateByExample(@Param("record") ServeOfBarber record, @Param("example") ServeOfBarberExample example);

    List<ServeOfBarberResult> selectBarberWithServeList(@Param("sid") int sid,@Param("id") int id);
}