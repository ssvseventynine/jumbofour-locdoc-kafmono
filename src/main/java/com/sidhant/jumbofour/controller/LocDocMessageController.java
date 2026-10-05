package com.sidhant.jumbofour.controller;

import com.sidhant.jumbofour.model.LocDocMessage;
import com.sidhant.jumbofour.repository.LocDocMessageRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class LocDocMessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final LocDocMessageRepository repository;

    // Spring will automatically inject these dependencies via Constructor Injection
    public LocDocMessageController(KafkaTemplate<String, String> kafkaTemplate, LocDocMessageRepository repository) {
        this.kafkaTemplate = kafkaTemplate;
        this.repository = repository;
    }

    // 1. Endpoint to Publish a message to Kafka
    @PostMapping
    public void publishMessage(@RequestBody LocDocMessage message) {
        kafkaTemplate.send("jumbofour-topic", message.getContent());
    }

    // 2. Endpoint to Fetch all messages from the MySQL database (for the UI list)
    @GetMapping
    public List<LocDocMessage> getMessages() {
        return repository.findAll();
    }
}