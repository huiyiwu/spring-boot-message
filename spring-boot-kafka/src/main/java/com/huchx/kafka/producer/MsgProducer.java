package com.huchx.kafka.producer;

import com.huchx.kafka.AppConstansts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;


/**
 * Author: Huchx
 * Date: 2021/1/20 16:18
 */
@Component
public class MsgProducer {

    @Resource
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void send(String topic,String msg){
        ListenableFuture<SendResult<String,Object>> feature = kafkaTemplate.send(topic,msg);
        feature.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Send发送消息失败");
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                System.out.println("Send发送消息成功");
            }
        });
    }
    public void send2(String topic,String key,String msg){
        ListenableFuture<SendResult<String,Object>> feature = kafkaTemplate.send(topic,key,msg);
        feature.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Send2发送消息失败");
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                System.out.println("Send2发送消息成功");
            }
        });
    }
}
