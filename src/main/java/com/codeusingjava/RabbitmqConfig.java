package com.codeusingjava;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

	@Value("rabbitmq.queue")
	private String qName="MessageQueue";
	
	
	@Value("rabbitmq.exchange")
	private String exchange;
	
	
	@Value("rabbitmq.routingKey")
	private String routingKey;

	@Bean
	Queue qu() {
		System.out.println("**********************");
		System.out.println(qName);
		return new Queue(qName, Boolean.FALSE);
	}

	@Bean
	TopicExchange topicExchange() {
		System.out.println("into exchange");
		return new TopicExchange(exchange);
	}

	@Bean
	Binding binding(final Queue q, final TopicExchange topicExchange) {
		return BindingBuilder.bind(q).to(topicExchange).with(routingKey);
	}
}
