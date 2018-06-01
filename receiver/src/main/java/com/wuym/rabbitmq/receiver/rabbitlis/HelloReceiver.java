package com.wuym.rabbitmq.receiver.rabbitlis;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("接收成功 ："  + msg);
    }
}
