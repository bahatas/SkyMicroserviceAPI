package com.sky.datasaverservice.service;



import com.sky.parentservice.model.Event;
import com.sky.parentservice.model.Market;
import com.sky.parentservice.model.Outcome;
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


    private DataSaveService dataSaveService;

    public RabbitListenerClass(DataSaveService dataSaveService) {
        this.dataSaveService = dataSaveService;
    }

    @Async
    @RabbitListener(queues = "feedme-queue")
    public void handleMessage(Outcome outcome){
        log.info("rabbitMQ Outcome LISTENER METHOD");
        System.out.println("outcome.toString() = " + outcome.toString());
        dataSaveService.saveOutcome(outcome);

    }

    @Async
    @RabbitListener(queues = "feedme-queue")
    public void handleMessage(Market market){
        log.info("rabbitMQ Market LISTENER METHOD");
        System.out.println("market.toString() = " + market.toString());
        dataSaveService.saveMarket(market);
    }

    @Async
    @RabbitListener(queues = "feedme-queue")
    public void handleMessage(Event event){
        log.info("rabbitMQ Event LISTENER METHOD");
        System.out.println("event.toString() = " + event.toString());
        dataSaveService.saveEvent(event);
    }

}
