package com.event.manager.mapper;


import com.event.manager.domain.Participant;
import com.event.manager.dto.ParticipantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParticipantMapper {
    ParticipantMapper INSTANCE = Mappers.getMapper(ParticipantMapper.class);

    Participant toParticipant(ParticipantDTO participantDTO);
}
