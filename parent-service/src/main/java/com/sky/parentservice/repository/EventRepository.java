package com.sky.parentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<EventEntity,String> {

}
