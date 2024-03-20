package com.example.springrabbitmqconsumer.consume;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springrabbitmqconsumer.config.RabbitMqConfig;
import com.example.springrabbitmqconsumer.entity.DealerType;
import com.example.springrabbitmqconsumer.service.FileProcessService;

@Component
public class RabbitMqConsume {

	@Autowired
	private FileProcessService fileProcessService;
	
	@RabbitListener(queues = RabbitMqConfig.queue)
	public void consume(DealerType dealertype) {
		System.out.println(dealertype);
		fileProcessService.saveConsumeRecords(dealertype);
	}
}
