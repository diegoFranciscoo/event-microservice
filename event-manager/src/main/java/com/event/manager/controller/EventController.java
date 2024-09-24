package com.event.manager.controller;


import com.event.manager.domain.Event;
import com.event.manager.dto.EventDTO;
import com.event.manager.dto.EventParticipantRegisterDTO;
import com.event.manager.service.EventParticipantRegistrationService;
import com.event.manager.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService service;
    private final EventParticipantRegistrationService eventParticipantRegistrationService;

    @PostMapping("/create")
    public ResponseEntity<Event> createNewEvent(@RequestBody EventDTO request) {
        return new ResponseEntity<>(service.createNewEvent(request), HttpStatus.CREATED);
    }

    @PostMapping("/registerParticipant")
    public ResponseEntity<Event> registerParticipantEvent(@RequestBody EventParticipantRegisterDTO request) {
        return new ResponseEntity<>(eventParticipantRegistrationService.registerParticipantEvent(request), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> findAllEvents() {
        return new ResponseEntity<>(service.findAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Event>> findByTitle(@RequestParam String title) {
        return new ResponseEntity<>(service.findByTitle(title), HttpStatus.OK);
    }
}
