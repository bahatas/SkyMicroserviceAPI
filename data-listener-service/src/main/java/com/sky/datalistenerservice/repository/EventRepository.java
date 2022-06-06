package com.sky.datalistenerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<EventEntity,String> {

}
