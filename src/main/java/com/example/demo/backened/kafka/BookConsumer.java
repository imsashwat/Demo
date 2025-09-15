package com.example.demo.backened.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookConsumer {

    @KafkaListener(topics = "book_topic", groupId = "book-group")
    public void listen(String message) {
        System.out.println("📥 Book Event Received: " + message);
    }
}

