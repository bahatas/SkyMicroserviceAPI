package com.sky.datasaverservice.service;

import com.sky.datasaverservice.util.MapperUtil;
import com.sky.parentservice.model.Event;
import com.sky.parentservice.model.Market;
import com.sky.parentservice.model.Outcome;
import com.sky.parentservice.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DataSaveServiceImpl implements DataSaveService {

    private OutComeRepository outComeRepository;
    private EventRepository eventRepository;
    private MarketRepository marketRepository;
    private MapperUtil mapperUtil;

    public DataSaveServiceImpl(OutComeRepository outComeRepository, EventRepository eventRepository, MarketRepository marketRepository, MapperUtil mapperUtil) {
        this.outComeRepository = outComeRepository;
        this.eventRepository = eventRepository;
        this.marketRepository = marketRepository;
        this.mapperUtil = mapperUtil;
    }

    public void saveOutcome(Outcome outcome) {

        OutcomeEntity outcomeEntity = mapperUtil.convert(outcome, new OutcomeEntity());
        outComeRepository.save(outcomeEntity);

    }

    public void saveMarket(Market market) {

        MarketEntity marketEntity = mapperUtil.convert(market, new MarketEntity());
        marketRepository.save(marketEntity);

    }

    public void saveEvent(Event event) {

        EventEntity eventEntity = mapperUtil.convert(event,new EventEntity());
        eventRepository.save(eventEntity);

    }
}
