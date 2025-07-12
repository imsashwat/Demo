// package com.example.demo.kafka;


// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.stereotype.Component;

// @Component
// public class BookProducer {

//     private final KafkaTemplate<String, String> kafkaTemplate;

//     public BookProducer(KafkaTemplate<String, String> kafkaTemplate) {
//         this.kafkaTemplate = kafkaTemplate;
//     }

//     public void sendBookCreatedMessage(String message) {
//         kafkaTemplate.send("book_topic", message);
//     }
// }



