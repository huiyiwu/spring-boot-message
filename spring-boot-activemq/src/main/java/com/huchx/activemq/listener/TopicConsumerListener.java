package com.huchx.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Author: Huchx
 * Date: 2021/1/12 11:19
 */
@Component
public class TopicConsumerListener {

    @JmsListener(destination = "${spring.activemq.topic-name}",containerFactory = "topicListener")
    public void topicRecive(String msg){
        System.out.println("topic接收到消息："+msg);
    }
}
