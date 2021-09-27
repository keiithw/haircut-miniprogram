package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.example.ServeExample;
import com.haiyu.manager.pojo.Serve;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


@Repository
public interface ServeMapper{
    int countByExample(ServeExample example);

    int deleteByExample(ServeExample example);

    int insert(Serve record);

    int insertSelective(Serve record);

    List<Serve> selectByExample(ServeExample example);

    int updateByExampleSelective(@Param("record") Serve record, @Param("example") ServeExample example);

    int updateByExample(@Param("record") Serve record, @Param("example") ServeExample example);
}