package com.sky.parentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutComeRepository extends MongoRepository<OutcomeEntity,String> {
}
