package com.huchx.kafka.consumer;

import com.huchx.kafka.AppConstansts;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Author: Huchx
 * Date: 2021/1/20 16:28
 */
@Component
public class MsgConsumer {

    @KafkaListener(topics = AppConstansts.TOPIC,groupId = AppConstansts.TOPIC_GROUP_1)
    public void topic_1(ConsumerRecord<?,?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        Optional obj = Optional.ofNullable(record.value());
        if (obj.isPresent()){
            Object msg = obj.get();
            System.out.println("Topic_1 消费了Topic:"+topic+",Message:"+msg);
            ack.acknowledge();
        }
    }

    @KafkaListener(topics = AppConstansts.TOPIC,groupId = AppConstansts.TOPIC_GROUP_2)
    public void topic_group_2(ConsumerRecord<?,?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        Optional obj = Optional.ofNullable(record.value());
        if (obj.isPresent()){
            Object msg = obj.get();
            System.out.println("Topic Group 2 消费了Topic:"+topic+",Message:"+msg);
            ack.acknowledge();
        }
    }
}
