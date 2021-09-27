package com.haiyu.manager.common;


import com.haiyu.manager.common.utils.SmsSender;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver {

    @RabbitHandler
    public void sendMsg(Map<String,String> smsParam) {
        System.out.println("DirectReceiver消费者收到消息  : " + smsParam.toString());
        SmsSender.sendApmSuccess(smsParam);
    }

}
