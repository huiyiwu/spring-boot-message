package com.huchx.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Author: Huchx
 * Date: 2021/1/12 11:03
 */
@RestController
public class ProducerController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    Queue queue;

    @Autowired
    Topic topic;

    /**
     * 点对点发送
     * @return
     */
    @RequestMapping("queue")
    public String queue(){
        this.jmsMessagingTemplate.convertAndSend(this.queue,"Queue Send");
        return "Queue Success Send";
    }

    /**
     * 发布-订阅模式发送
     * @return
     */
    @RequestMapping("topic")
    public String topic(){
        this.jmsMessagingTemplate.convertAndSend(this.topic,"Topic Send");
        return "Topic Success Send";
    }
}
