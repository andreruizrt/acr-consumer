package acr.AcrConsumer.AcrConsumer.controllers;

import acr.AcrConsumer.AcrConsumer.Service.ExecutionService;
import acr.AcrConsumer.AcrConsumer.models.Execution;

import acr.AcrConsumer.AcrConsumer.repositories.ExecutionRepository;
import lombok.RequiredArgsConstructor;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@RequiredArgsConstructor
public class ExecutionController {

	private final Integer TOPIC_PARTITIONS_COUNT = 3;
	private final Integer TOPIC_REPLICATIONS_COUNT = 3;
	private final String TOPIC_NAME = "execution";
	private final String TOPIC_OFFSET = "1";

	@Bean
	public NewTopic createTopic() {
		System.out.println("KafkaConsumer::createTopic");
		return TopicBuilder.name(TOPIC_NAME )
				.partitions(TOPIC_PARTITIONS_COUNT)
				.replicas(TOPIC_REPLICATIONS_COUNT)
				.build();
	}

	@KafkaListener(topics=TOPIC_NAME, groupId="group_id")
	public void consumer(String message) {
		System.out.println("ExecutionController::consumer" + message);
	}

}
