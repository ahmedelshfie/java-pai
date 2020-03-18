package com.eventsource.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventsource.api.model.Event;

@Repository
public interface EventSourceRepository extends JpaRepository<Event, String> {

	Event findById(long codigo);
}
