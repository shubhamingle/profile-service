package com.reliance.profile.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private final String KAFKA_TOPIC = "NOTIFICATION_TOPIC";

	public void send(String message) {
		kafkaTemplate.send(KAFKA_TOPIC, message);
	}

}
