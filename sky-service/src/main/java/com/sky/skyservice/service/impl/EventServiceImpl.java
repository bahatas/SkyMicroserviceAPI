package com.sky.skyservice.service.impl;

import com.sky.parentservice.model.Event;
import com.sky.parentservice.repository.EventEntity;
import com.sky.parentservice.repository.EventRepository;
import com.sky.skyservice.service.EventService;
import com.sky.skyservice.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
@ComponentScan("sky.com")
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private MapperUtil mapperUtil;

    public EventServiceImpl(EventRepository eventRepository, MapperUtil mapperUtil) {
        this.eventRepository = eventRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<Event>getAllEventWithPagination() {
        int page =0;
        int size = 3;
        Pageable paging = PageRequest.of(page, size);
        Page<EventEntity> EventEntityPage;

        Page<EventEntity> all = eventRepository.findAll(paging);

        log.info(  all.getContent().toString());


        List<Event> collect = all.getContent().stream().map(e -> mapperUtil.convert(e, new Event())).collect(Collectors.toList());
        return collect;



    }

    @Override
    public Event getEventById(Long id) {
        return null;
    }
}
