package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.Star;
import com.haiyu.manager.pojo.example.StarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarMapper {
    int countByExample(StarExample example);

    int deleteByExample(StarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Star record);

    int insertSelective(Star record);

    List<Star> selectByExample(StarExample example);

    Star selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Star record, @Param("example") StarExample example);

    int updateByExample(@Param("record") Star record, @Param("example") StarExample example);

    int updateByPrimaryKeySelective(Star record);

    int updateByPrimaryKey(Star record);
}