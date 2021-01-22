package com.huchx.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class KafkaApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(KafkaApp.class,args);
    }
}
