package com.sky.datalistenerservice.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sky.datalistenerservice.model.BaseDto;
import com.sky.datalistenerservice.repository.EventRepository;
import com.sky.datalistenerservice.repository.MarketRepository;
import com.sky.datalistenerservice.repository.OutcomeRepository;
import com.sky.datalistenerservice.tcp.DataEvent;
import com.sky.datalistenerservice.util.MapperUtil;
import com.sky.datalistenerservice.model.*;
import com.sky.datalistenerservice.repository.*;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.Socket;


@Slf4j
@Service
@MessageEndpoint
public class DataServiceImp {

    @Autowired
    private MapperUtil modelMapper;
    @Autowired
    private OutcomeRepository outcomeRepository;
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    MarketRepository marketRepository;

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @EventListener(DataEvent.class)
    @Order(1)
    @Async
    public BaseDto getDtoObjectFromStream(DataEvent dataEvent) throws JsonProcessingException {
        log.info("getDtoObjectFromStream method is invoked");


        String incomingData = String.valueOf(dataEvent);
        log.info("incomingData -->" + incomingData);
        int startingIndexOfData = incomingData.indexOf("[") + 8;  // "source="  object name added
        int endingIndexOfData = incomingData.indexOf("]");

        incomingData = incomingData.substring(startingIndexOfData, endingIndexOfData);

        System.out.println("incomingData = " + incomingData);

        /**
         * this is instance of stream data
         */
        //com.skybet.feedme.tcp.DataEvent[source=|30018|create|market|1653921730618|790959a9-a673-4509-a616-6d276ba72ab4|2d4e2fe2-883a-4b1f-aa92-b84dcd03f008|Goal Handicap (+1)|0|1|]


        BaseDto dto;

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter obj = new ObjectMapper().writer().withDefaultPrettyPrinter();


        String modifiedLine = incomingData.replace("\\|", "");
        System.out.println("modifiedLine = " + modifiedLine);
        String[] fields = modifiedLine.split("\\|");


        if (fields[3].equals("outcome")) {


            Outcome outcome = getOutcome(fields);
            Outcome copyoutcome = new Outcome();
            copyoutcome = outcome;
            System.out.println("outcome = " + outcome.toString());
            OutcomeEntity map = modelMapper.convert(copyoutcome, new OutcomeEntity());
            rabbitMqSender.sendOutcome(copyoutcome);
            outcomeRepository.save(map);
            log.info("outcome saved ");
            String json = obj.writeValueAsString(outcome);
            System.out.println("json = " + json);

            return outcome;

        }
        if (fields[3].equals("market")) {
            Market market = getMarket(fields);
            MarketEntity convert = modelMapper.convert(market, new MarketEntity());

            System.out.println("market.toString() = " + market.toString());

            rabbitMqSender.sendMarket(market);
            marketRepository.save(convert);
            log.info("market saved ");
            String json = obj.writeValueAsString(market);
            System.out.println("json = " + json);
            return market;
        }
        if (fields[3].equals("event")) {
            Event event = getEvent(fields);
            System.out.println("event = " + event.toString());

            rabbitMqSender.sendEvent(event);
            EventEntity map = modelMapper.convert(event, new EventEntity());
            eventRepository.save(map);
            log.info("event saved ");
            String json = obj.writeValueAsString(event);
            System.out.println("json = " + json);

            return event;
        }
        return null;

    }

    public static Outcome getOutcome(String[] fields) {
        return Outcome.builder()
                .msgId(Integer.valueOf(fields[1]))
                .operation(fields[2])
                .type(fields[3])
                .timeStamp(fields[4])
                .marketId(fields[5])
                .outcomeId(fields[6])
                .name(fields[7])
                .price(fields[8])
                .displayed(fields[9])
                .suspended(fields[10])
                .build();
    }

    public static Market getMarket(String[] fields) {
        return Market.builder()
                .msgId(Integer.valueOf(fields[1]))
                .operation(fields[2])
                .type(fields[3])
                .timeStamp(fields[4])
                .eventId(fields[5])
                .marketId(fields[6])
                .name(fields[7])
                .displayed(fields[8])
                .suspended(fields[9])
                .build();
    }

    public static Event getEvent(String[] fields) {

        return Event.builder()
                .msgId(Integer.valueOf(fields[1]))
                .operation(fields[2])
                .type(fields[3])
                .timeStamp(fields[4])
                .eventId(fields[5])
                .category(fields[6])
                .subCategory(fields[7])
                .name(fields[8])
                .startTime(fields[9])
                .displayed(fields[10])
                .suspended(fields[11])
                .build();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterStart(){


    }
    //    todo generic type conversion
    public static <T> T getCorrectObject(String type) {

        switch (type) {
            case "event":
                return (T) new Event();
            case "outcome":
                return (T) new Outcome();
            case "market":
                return (T) new Market();
        }

        return null;

    }




}
