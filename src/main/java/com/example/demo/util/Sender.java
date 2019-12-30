package com.example.demo.util;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送--生产消息
 */
@Component
public class Sender {
    @Autowired
    AmqpTemplate amqpTemplate;
    public void send(String s){
        System.out.println("发送消息：" + s);
        amqpTemplate.convertAndSend("direct", s);
    }
}
