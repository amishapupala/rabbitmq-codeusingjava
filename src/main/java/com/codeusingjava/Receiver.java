package com.codeusingjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.context.annotation.Bean;

@Component
public class Receiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	@Autowired
	Queue qu;

	@RabbitListener(queues = "#{qu.getName()}")	
	
	public void getMsg(final String message) {
		System.out.println("receiver start");
		LOGGER.info("Getting messages.....");
		LOGGER.info("Finally Receiver received the message and the message  is..\n" + message);
	}
}
