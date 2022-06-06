package com.sky.parentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarketRepository extends MongoRepository<MarketEntity,String> {
}
