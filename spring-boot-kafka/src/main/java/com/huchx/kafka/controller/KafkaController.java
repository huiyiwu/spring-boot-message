package com.huchx.kafka.controller;

import com.huchx.kafka.AppConstansts;
import com.huchx.kafka.producer.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Author: Huchx
 * Date: 2021/1/20 16:34
 */
@RestController
public class KafkaController {
    @Autowired
    MsgProducer msgProducer;

    @RequestMapping("/send")
    public String send(){
        msgProducer.send(AppConstansts.TOPIC,"此消息由Controller发送");
        return "send success";
    }
}
