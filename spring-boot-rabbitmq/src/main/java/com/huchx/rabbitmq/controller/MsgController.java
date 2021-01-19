package com.huchx.rabbitmq.controller;

import com.huchx.rabbitmq.AppConstants;
import com.huchx.rabbitmq.config.RabbitConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Huchx
 * Date: 2021/1/19 16:12
 */
@RestController
public class MsgController{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String sendMsg(String queue,String msg){
        if (StringUtils.isEmpty(msg)){
            msg="默认消息";
        }
        if (StringUtils.isEmpty(queue)){
            queue="1";
        }
        if (queue.equals("1")){
            rabbitTemplate.convertAndSend(AppConstants.EXCHANGE,AppConstants.ROUTINGKEY,msg);
        }else if (queue.equals("2")){
            rabbitTemplate.convertAndSend(AppConstants.EXCHANGE,AppConstants.ROUTINGKEY_2,msg);
        }
        return "send success";
    }
}
