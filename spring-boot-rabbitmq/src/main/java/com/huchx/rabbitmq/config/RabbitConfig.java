package com.huchx.rabbitmq.config;

import com.huchx.rabbitmq.AppConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


/**
 * Author: Huchx
 * Date: 2021/1/18 17:16
 */
@Configuration
public class RabbitConfig {
    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory factory = new CachingConnectionFactory(host,port);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost("/");
        factory.setPublisherConfirms(true);
        return factory;
    }

    /**
     * 交换机
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }
    @Bean
    public DirectExchange defaultExcange(){
        return new DirectExchange(AppConstants.EXCHANGE);
    }

    /**
     * 注入队列1
     * @return
     */
    @Bean
    public Queue queue1(){
        return new Queue(AppConstants.QUEUE,true);
    }

    /**
     * 通过路由Key将队列1绑定到交换机
     * @return
     */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue1()).to(defaultExcange()).with(AppConstants.ROUTINGKEY);
    }
    /**
     * 注入队列1
     * @return
     */
    @Bean
    public Queue queue2(){
        return new Queue(AppConstants.QUEUE_2,true);
    }
    /**
     * 通过路由Key将队列2绑定到交换机
     * @return
     */
    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(queue2()).to(defaultExcange()).with(AppConstants.ROUTINGKEY_2);
    }

}
