package com.danieldev.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.danieldev.api.models.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long>{

}
