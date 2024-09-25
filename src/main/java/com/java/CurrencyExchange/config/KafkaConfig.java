package com.java.CurrencyExchange.config;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import org.springframework.kafka.support.serializer.JsonSerializer;
import org.apache.kafka.common.serialization.StringSerializer;


@EnableKafka
@Configuration
public class KafkaConfig {
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(){
	 return new KafkaTemplate<>(producerFactory());
	}

	@Bean
    public ProducerFactory<String, String> producerFactory(){
   	return new DefaultKafkaProducerFactory<>(producerConfiguration());
    }
	
	@Bean
	public Map<String, Object> producerConfiguration(){
		
		return Map.of(
				ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092",
				ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class,
				ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class
				);}
	
	
	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name("currencyTopic").partitions(1).replicas(1).build();
	}


}
