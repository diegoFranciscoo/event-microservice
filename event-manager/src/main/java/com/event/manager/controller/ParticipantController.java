package com.event.manager.controller;


import com.event.manager.domain.Participant;
import com.event.manager.dto.ParticipantDTO;
import com.event.manager.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participant")
@RequiredArgsConstructor
public class ParticipantController {
    private final ParticipantService service;

    @PostMapping("/register")
    public ResponseEntity<Participant> registerParticipant(@RequestBody ParticipantDTO request) {
        return new ResponseEntity<>(service.registerParticipant(request), HttpStatus.CREATED);
    }
}
