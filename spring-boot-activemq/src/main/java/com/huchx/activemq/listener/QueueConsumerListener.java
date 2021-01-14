package com.huchx.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Author: Huchx
 * Date: 2021/1/12 11:18
 */
@Component
public class QueueConsumerListener {

    @JmsListener(destination = "${spring.activemq.queue-name}",containerFactory = "queueListener")
    public void readActiveQueue(String msg){
        System.out.println("queue接收到消息："+msg);
    }
}
