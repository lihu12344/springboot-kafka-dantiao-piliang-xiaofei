package com.example.demo.controller;

import com.example.demo.producer.ProducerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private ProducerService producerService;

    @RequestMapping("/send")
    public String hello(){
        try{
            producerService.sendSync();
        }catch (Exception e){
            e.printStackTrace();
        }

        return "success";
    }

    @RequestMapping("/send2")
    public String hello2(){
        producerService.sendAsync();

        return "success 2";
    }

    @RequestMapping("/send3")
    public String hello3(){
        try{
            producerService.sendSync2();
        }catch (Exception e){
            e.printStackTrace();
        }

        return "success";
    }

    @RequestMapping("/send4")
    public String hello4(){
        producerService.sendAsync2();

        return "success";
    }
}
