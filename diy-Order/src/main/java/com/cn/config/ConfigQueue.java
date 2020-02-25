package com.cn.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;


@Component
public class ConfigQueue {

    @Value("${my_queue}")
    private String myQueue;

    @Value("${my_topic}")
    private String myTopic;

    @Bean
    public Queue queue(){
        return  new ActiveMQQueue(myQueue);
    }

    @Bean
    public Topic topic(){
        return  new ActiveMQTopic(myTopic);
    }



}
