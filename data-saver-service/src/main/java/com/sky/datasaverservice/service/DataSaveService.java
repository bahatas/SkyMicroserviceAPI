package com.sky.datasaverservice.service;

import com.sky.parentservice.model.Event;
import com.sky.parentservice.model.Market;
import com.sky.parentservice.model.Outcome;

public interface DataSaveService {
    void saveEvent(Event event);

    void saveMarket(Market market);

    void saveOutcome(Outcome outcome);
}
