package com.example.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(groupId = "consumerGroup",topics = "sync")
    public void onMessage(ConsumerRecords<Object,String> consumerRecords) {
        for(TopicPartition topicPartition:consumerRecords.partitions()){
            for (ConsumerRecord<Object,String> consumerRecord:consumerRecords.records(topicPartition)){
                System.out.println("消费时间："+System.currentTimeMillis()+"  "+consumerRecord.value());
            }
        }
    }

    @KafkaListener(groupId = "consumerGroup2",topics = "async")
    public void consume2(ConsumerRecords<Object,String> consumerRecords){
        for (TopicPartition topicPartition:consumerRecords.partitions()){
            for (ConsumerRecord<Object,String> consumerRecord:consumerRecords.records(topicPartition)){
                System.out.println("消费时间："+System.currentTimeMillis()+"  "+consumerRecord.value());
            }
        }
    }
}