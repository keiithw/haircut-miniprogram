package com.haiyu.manager.service;

import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.pojo.Appointment;

import java.util.List;

public interface AppointmentService {
    RestResult cancel(int aid);

    List<Appointment> getFutureAppointment(Appointment appointment);

    Integer totalIncome(int sid);

    Integer countWaitingApmBySid(int sid);
}
