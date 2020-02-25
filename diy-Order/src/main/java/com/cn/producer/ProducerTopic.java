package com.cn.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class ProducerTopic {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

    //每隔5秒向队列发布消息
    //@Scheduled(fixedDelay = 5000)
    public void send(){
        String msg = System.currentTimeMillis()+"";
        jmsMessagingTemplate.convertAndSend(topic,msg);
        System.out.println("采用发布订阅通讯方式，msg："+ msg);
    }
}
