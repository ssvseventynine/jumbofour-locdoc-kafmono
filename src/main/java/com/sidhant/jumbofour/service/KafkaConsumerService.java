package com.sidhant.jumbofour.service;

import com.sidhant.jumbofour.model.LocDocMessage;
import com.sidhant.jumbofour.repository.LocDocMessageRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final LocDocMessageRepository repository;

    public KafkaConsumerService(LocDocMessageRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "jumbofour-topic", groupId = "jumbofour-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(String messageContent) {
        // Create a new entity instance and save it to MySQL via Hibernate
        LocDocMessage message = new LocDocMessage(messageContent);
        repository.save(message);
        System.out.println("Successfully consumed and persisted message: " + messageContent);
    }
}