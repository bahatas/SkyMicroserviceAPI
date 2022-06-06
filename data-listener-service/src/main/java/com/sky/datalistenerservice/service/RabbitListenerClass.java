package com.sky.datalistenerservice.service;


import com.sky.datalistenerservice.model.Event;
import com.sky.datalistenerservice.model.Market;
import com.sky.datalistenerservice.model.Outcome;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitListenerClass {

    @Value("${feedme.rabbitmq.queue}")
    String queueName;

//    @Async
//    @RabbitListener(queues = "feedme-queue")
//    public void handleMessage(DataEvent dataEvent){
//        log.info("rabbit MQ LISTENER METHOD");
//        System.out.println(dataEvent.toString());
//    }
    @Async
    @RabbitListener(queues = "feedme-queue")
    public void handleMessage(Outcome outcome){
        log.info("rabbitMQ Outcome LISTENER METHOD");
        System.out.println("outcome.toString() = " + outcome.toString());
    }

    @Async
    @RabbitListener(queues = "feedme-queue")
    public void handleMessage(Market market){
        log.info("rabbitMQ Market LISTENER METHOD");
        System.out.println("market.toString() = " + market.toString());
    }

    @Async
    @RabbitListener(queues = "feedme-queue")
    public void handleMessage(Event event){
        log.info("rabbitMQ Event LISTENER METHOD");
        System.out.println("event.toString() = " + event.toString());
    }

}
