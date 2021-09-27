package com.haiyu.manager.controller.system;

import com.haiyu.manager.common.utils.DateUtils;
import com.haiyu.manager.common.utils.SmsSender;
import com.haiyu.manager.dao.AppointmentMapper;
import com.haiyu.manager.pojo.Appointment;
import com.haiyu.manager.pojo.example.AppointmentExample;
import com.haiyu.manager.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@EnableScheduling
@EnableAsync
@Configuration
public class ScheduleTask {

    @Autowired
    private AppointmentMapper apmMapper;


    //等待通知
    @Scheduled(cron = "0 */1 * * * ?")
    @Async
    public void apmNoticeProcessor() {
        Date now = new Date();
        long time = 60*60*1000;//60分钟
        Date afterDate = new Date(now.getTime() + time);//60分钟后的时间
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        List<Appointment> toNoticeApm = apmMapper.selectToNoticeApm(now, afterDate);
        if (!toNoticeApm.isEmpty()){
            toNoticeApm.forEach(apm->{
                executorService.submit(()->{
                    Date rawDate = apm.getCreatedTime();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date = sdf.format(rawDate);
                    SmsSender.sendNoticeSms(apm.getCustomerPhone(), date,apm.getServerName());
                    System.out.println("发送了");
                    System.err.println(Thread.currentThread().toString()+"负责发送"+apm.getCustomerPhone()+"的短信");
                });
                apm.setIsNotice(1);
                apmMapper.updateByPrimaryKeySelective(apm);
                System.err.println("更新"+apm.getCustomerName()+"的提醒状态");
            });
        }else {
            System.err.println("没有要提醒的");
        }
    }

    //过期预约
    @Scheduled(cron = "0 */3 * * * ?")
    //@Scheduled(cron = "*/5 * * * * ?")
    @Async
    public void apmOverTimeProcessor() {
        Date now = new Date();
        long time1 = 120*60*1000;
        Date beforeDate = new Date(now.getTime() - time1);//120分钟后的时间
        List<Appointment> overTimeApm = apmMapper.selectOverTimeApm(beforeDate);
        if (!overTimeApm.isEmpty()){
            overTimeApm.forEach(a->{
                a.setStatus(3);
                apmMapper.updateByPrimaryKeySelective(a);
                //短信通知

                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
