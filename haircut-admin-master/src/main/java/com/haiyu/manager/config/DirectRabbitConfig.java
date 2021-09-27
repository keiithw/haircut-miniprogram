package com.haiyu.manager.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {

    public static String TEST_DIRECT_QUEUE=  "TestDirectQueue";
    public static String TEST_DIRECT_EXCHANGE=  "TestDirectExchange";
    public static String TEST_DIRECT_ROUTING=  "TestDirectRouting";
    //队列 起名：TestDirectQueue
    @Bean
    public Queue TestDirectQueue() {
        return new Queue(TEST_DIRECT_QUEUE,true);
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange(TEST_DIRECT_EXCHANGE);
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with(TEST_DIRECT_ROUTING);
    }
}
