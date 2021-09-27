package com.haiyu.manager.controller.my;

import com.haiyu.manager.common.R;
import com.haiyu.manager.common.RestResult;
import com.haiyu.manager.common.utils.AdminUserUtil;
import com.haiyu.manager.common.utils.DateUtils;
import com.haiyu.manager.common.utils.RedisUtil;
import com.haiyu.manager.dao.AppointmentMapper;
import com.haiyu.manager.pojo.Appointment;
import com.haiyu.manager.service.AppointmentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentMapper appointmentMapper;
//    @Autowired
//    private RedisUtil redis;

    @PostMapping("/listAppointment")
    public RestResult listAppointment(Appointment appointment) throws ParseException {
        if (appointment.getBarberId() != null && appointment.getBarberId() == -555)
            appointment.setBarberId(null);
        if (appointment.getStatus() != null && appointment.getStatus() == -555)
            appointment.setStatus(null);
        String startTime = appointment.getStartTime();
        String endTime = appointment.getEndTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        if (StringUtils.isNotBlank(startTime)) {
            appointment.setStartTime1(simpleDateFormat.parse(startTime));
        }
        if (StringUtils.isNotBlank(endTime))
            appointment.setEndTime1(simpleDateFormat.parse(endTime));
        appointment.setSid(AdminUserUtil.getUser().getSid());
        List<Appointment> futureAppointment = appointmentService.getFutureAppointment(appointment);
        return R.getSuccessResult(futureAppointment);
    }

    @PostMapping("/cancel")
    public RestResult cancel(@RequestParam int aid, @RequestParam String phone) {
        return getCancelResult(aid, appointmentMapper);
    }

    public static RestResult getCancelResult(@RequestParam int aid, AppointmentMapper appointmentMapper) {
        Appointment appointment = new Appointment();
        appointment.setAid(aid);
        appointment.setStatus(3);
        appointmentMapper.updateByPrimaryKeySelective(appointment);
        return R.getSuccessResult();
    }

    @PostMapping("/enterStore")
    public RestResult enterStore(@RequestParam int aid) {
        Appointment appointment = new Appointment();
        appointment.setAid(aid);
        appointment.setStatus(1);
        int i = appointmentMapper.updateByPrimaryKeySelective(appointment);

        return R.getSuccessResult();
    }

    @PostMapping("/hasBeenPaid")
    public RestResult hasBeenPaid(@RequestParam int aid) {
        Appointment appointment = new Appointment();
        appointment.setAid(aid);
        appointment.setStatus(2);
        int i = appointmentMapper.updateByPrimaryKeySelective(appointment);
        return R.getSuccessResult();
    }
}
