package com.huchx.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 *消息传递ActiveMQ实现
 */
@SpringBootApplication
@EnableJms //启动消息队列
public class ActiveMQApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(ActiveMQApp.class,args);
    }
}
