package com.sky.skyservice.service;

import com.sky.parentservice.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    List<Event> getAllEventWithPagination();
    Event getEventById(Long id);
}
