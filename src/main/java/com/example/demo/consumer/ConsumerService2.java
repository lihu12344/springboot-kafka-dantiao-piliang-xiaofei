package com.example.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService2 {

    @KafkaListener(groupId = "consumerGroup1",topics = "sync1")
    public void onMessage(ConsumerRecord<Object,String> consumerRecord) {
        System.out.println("消费时间："+System.currentTimeMillis()+"  "+consumerRecord.value());
    }

    @KafkaListener(groupId = "consumerGroup2",topics = "async2")
    public void consume2(ConsumerRecord<Object,String> consumerRecord){
        System.out.println("消费时间："+System.currentTimeMillis()+"  "+consumerRecord.value());
    }
}