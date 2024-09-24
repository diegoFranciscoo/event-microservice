package com.event.manager.repository;

import com.event.manager.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByTitleContainingIgnoreCase(String title);
}
