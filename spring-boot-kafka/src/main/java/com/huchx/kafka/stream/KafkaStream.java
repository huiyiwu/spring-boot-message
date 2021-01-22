package com.huchx.kafka.stream;

import com.huchx.kafka.AppConstansts;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Huchx
 * Date: 2021/1/22 13:37
 */
@Configuration
public class KafkaStream {
    @Bean
    public KStream<String, String> kStream(StreamsBuilder streamsBuilder){
        KStream<String, String> stream = streamsBuilder.stream(AppConstansts.TOPIC_1, Consumed.with(Serdes.String(), Serdes.String()));
        stream.map((key, value) -> {
            value+="--huchx";
            return new KeyValue<>(key,value);
        }).to(AppConstansts.TOPIC_2);
        return stream;
    }
}
