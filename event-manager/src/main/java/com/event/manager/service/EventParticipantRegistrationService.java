package com.event.manager.service;


import com.event.manager.domain.Event;
import com.event.manager.domain.Participant;
import com.event.manager.dto.EventParticipantRegisterDTO;
import com.event.manager.exception.ParticipantExeception.ParticipantIsAlreadyRegisteredException;
import com.event.manager.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventParticipantRegistrationService {
    private final EventService eventService;
    private final EventRepository eventRepository;
    private final ParticipantService participantService;

    public Event registerParticipantEvent(EventParticipantRegisterDTO request) {
        Event event = eventService.findById(request.eventId());
        Participant participant = participantService.findByEmail(request.participantEmail());

        validateIfParticipantIsRegistered(event, participant);

        event.getParticipants().add(participant);

        return eventRepository.save(event);
    }

    public void validateIfParticipantIsRegistered(Event event, Participant participant){
        if (event.getParticipants().stream().anyMatch(p-> p.getId().equals(participant.getId()))){
            throw new ParticipantIsAlreadyRegisteredException("The participant is already registered for the event");
        }
    }

}
