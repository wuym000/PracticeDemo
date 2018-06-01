package com.wuym.rabbitmq.producer.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class ProController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/produce")
    public String produce(){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        for(int i=0; i < 200; i++){
            Date now = Calendar.getInstance().getTime();
            String str = sdf.format(now);
            rabbitTemplate.convertAndSend("hello", str);
            System.out.println("发布成功：" + str);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
}
