package com.event.manager.service;

import com.event.manager.domain.Participant;
import com.event.manager.dto.ParticipantDTO;
import com.event.manager.mapper.ParticipantMapper;
import com.event.manager.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository repository;

    public Participant registerParticipant(ParticipantDTO request) {
        return repository.save(ParticipantMapper.INSTANCE.toParticipant(request));
    }

    public Participant findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Participant does not exists"));
    }

    public Participant findByEmail(String email) {
        return repository.findParticipantByEmail(email).orElseThrow(() -> new IllegalArgumentException("Participant does not exists"));
    }
}
