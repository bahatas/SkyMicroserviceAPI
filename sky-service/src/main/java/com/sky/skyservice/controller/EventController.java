package com.sky.skyservice.controller;

import com.sky.parentservice.model.Event;
import com.sky.parentservice.repository.EventRepository;
import com.sky.skyservice.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {



   private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/get-10-event")
    public ResponseEntity<List<Event>> readAllEvent(){
        //todo pagination

        List<Event> allEventWithPagination = eventService.getAllEventWithPagination();
        return ResponseEntity.ok(allEventWithPagination);
    }
}
