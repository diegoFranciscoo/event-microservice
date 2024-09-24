package com.event.manager.mapper;


import com.event.manager.domain.Event;
import com.event.manager.dto.EventDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    Event toEvent(EventDTO eventDTO);
}
