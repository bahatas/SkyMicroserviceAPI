package com.sky.parentservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<EventEntity,String> {

    @Override
    Page<EventEntity> findAll(Pageable pageable);

    Page<EventEntity> findByPublished(boolean published, Pageable pageable);

    Page<EventEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
