package com.event.manager.repository;

import com.event.manager.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Long>{

    Optional<Participant> findParticipantByEmail(String email);
}
