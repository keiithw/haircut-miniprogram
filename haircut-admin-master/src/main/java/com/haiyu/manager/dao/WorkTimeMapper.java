package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.WorkTime;
import com.haiyu.manager.pojo.example.WorkTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTimeMapper {
    int countByExample(WorkTimeExample example);

    int deleteByExample(WorkTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkTime record);

    int insertSelective(WorkTime record);

    List<WorkTime> selectByExample(WorkTimeExample example);

    WorkTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkTime record, @Param("example") WorkTimeExample example);

    int updateByExample(@Param("record") WorkTime record, @Param("example") WorkTimeExample example);

    int updateByPrimaryKeySelective(WorkTime record);

    int updateByPrimaryKey(WorkTime record);
}