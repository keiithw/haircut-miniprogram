package com.haiyu.manager.service.impl;

import com.haiyu.manager.common.R;
import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.dao.AppointmentMapper;
import com.haiyu.manager.pojo.Appointment;
import com.haiyu.manager.pojo.example.AppointmentExample;
import com.haiyu.manager.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.haiyu.manager.controller.my.AppointmentController.getCancelResult;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Override
    public RestResult cancel(int aid) {
        return getCancelResult(aid, appointmentMapper);
    }

    @Override
    public List<Appointment> getFutureAppointment(Appointment appointment) {
        List<Appointment> futureAppointment = appointmentMapper.getFutureAppointment(appointment);
        return futureAppointment;
    }

    @Override
    public Integer totalIncome(int sid) {
        Integer integer = appointmentMapper.totalIncome(sid);
        return integer;
    }

    @Override
    public Integer countWaitingApmBySid(int sid) {
        AppointmentExample example = new AppointmentExample();
        example.createCriteria().andSidEqualTo(sid).andStatusEqualTo(1);
        int i = appointmentMapper.countByExample(example);
        return i;
    }
}
