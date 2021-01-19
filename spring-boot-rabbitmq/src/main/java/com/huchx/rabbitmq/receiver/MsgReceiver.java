package com.huchx.rabbitmq.receiver;

import com.huchx.rabbitmq.AppConstants;
import com.huchx.rabbitmq.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author: Huchx
 * Date: 2021/1/19 16:24
 */
@Component
public class MsgReceiver {

    @RabbitHandler
    @RabbitListener(queues = AppConstants.QUEUE)
    public void process(String msg){
        System.out.println("接收到队列1中的消息，内容为："+msg);
    }
    @RabbitHandler
    @RabbitListener(queues = AppConstants.QUEUE_2)
    public void process2(String msg){
        System.out.println("接收到队列2中的消息，内容为："+msg);
    }
}
