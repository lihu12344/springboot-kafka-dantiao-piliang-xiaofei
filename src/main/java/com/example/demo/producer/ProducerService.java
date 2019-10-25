package com.example.demo.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

@Service
public class ProducerService {

    @Resource
    private KafkaTemplate<Object,String> kafkaTemplate;

    public void sendSync() throws ExecutionException, InterruptedException {
        for (int i=0;i<100;i++){
            SendResult<Object,String> result=kafkaTemplate.send("sync","瓜田李下 同步发送"+i).get();
            System.out.println("发送时间："+System.currentTimeMillis()+"  "+result);
        }
    }

    public void sendAsync() {
        for (int i=0;i<100;i++){
            kafkaTemplate.send("async","瓜田李下 异步发送"+i);
        }
    }

    public void sendSync2() throws Exception {
        for (int i=0;i<100;i++){
            SendResult<Object,String> result=kafkaTemplate.send("sync1","瓜田李下 同步发送"+i).get();
            System.out.println("发送时间："+System.currentTimeMillis()+"  "+result);
        }
    }

    public void sendAsync2(){
        for (int i=0;i<100;i++){
            kafkaTemplate.send("async2","瓜田李下 异步发送"+i);
        }
    }
}
