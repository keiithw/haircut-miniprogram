package com.haiyu.manager.dao;

import com.haiyu.manager.pojo.Appointment;
import com.haiyu.manager.pojo.example.AppointmentExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentMapper {
    int countByExample(AppointmentExample example);

    int deleteByExample(AppointmentExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    List<Appointment> selectByExample(AppointmentExample example);

    Appointment selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Appointment record, @Param("example") AppointmentExample example);

    int updateByExample(@Param("record") Appointment record, @Param("example") AppointmentExample example);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);

    List<Appointment> getFutureAppointment(Appointment appointment);

    List<Appointment> selectToNoticeApm(@Param("start") Date start,@Param("end") Date end);

    List<Appointment> selectOverTimeApm(@Param("start") Date start);

    Double getAvgPrice(Integer sid);

    Integer totalIncome(Integer sid);

    Integer selectEarlierApm(Integer bid,Date day);
}