package com.sky.datalistenerservice.service;

import com.sky.parentservice.model.Event;
import com.sky.parentservice.model.Market;
import com.sky.parentservice.model.Outcome;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${feedme.rabbitmq.exchange}")
    String exchange;

    @Value("${feedme.rabbitmq.routingkey}")
    private String routingkey;

    @Async
    public void sendOutcome(Outcome outcome){
        log.info(" RABBITMQ sendOutcome METHOD INVOKED ");
        amqpTemplate.convertAndSend(exchange,routingkey,outcome);
        log.info(" RABBITMQ ** OUTCOME ** MESSAGE SENT ");
    }
    @Async
    public void sendMarket(Market market){
        log.info(" RABBITMQ sendMarket METHOD INVOKED ");
        amqpTemplate.convertAndSend(exchange,routingkey,market);
        log.info(" RABBITMQ ** MARKET ** MESSAGE SENT ");
    }

    @Async
    public void sendEvent(Event event){
        log.info(" RABBITMQ sendEvent METHOD INVOKED ");
        amqpTemplate.convertAndSend(exchange,routingkey,event);
        log.info(" RABBITMQ ** MARKET ** MESSAGE SENT ");
    }

}
