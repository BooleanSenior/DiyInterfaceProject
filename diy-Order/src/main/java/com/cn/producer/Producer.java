package com.cn.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;

@Component
public class Producer {
    @Resource
    private JmsMessagingTemplate  jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    //每隔5秒向队列发布消息
   // @Scheduled(fixedDelay = 5000)
    public void send(){
        String msg = System.currentTimeMillis()+"";
        jmsMessagingTemplate.convertAndSend(queue,msg);
        System.out.println("采用点对点通讯方式，msg："+ msg);
    }
}
