package com.cn.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    //考虑幂等性问题
  //  @JmsListener(destination = "${my_queue}")
    public void receive(String msg){
        System.out.println("采用点对点模式，消费者获取到生产者消息，msg：" + msg);
    }

    @JmsListener(destination = "${my_topic}")
    public void receivetopic(String msg){
        System.out.println("采用订阅模式，消费者获取到生产者消息，msg：" + msg);
    }
}
