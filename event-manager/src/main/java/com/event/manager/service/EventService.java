package com.event.manager.service;


import com.event.manager.domain.Event;
import com.event.manager.dto.EventDTO;
import com.event.manager.feign.GatewayClient;
import com.event.manager.mapper.EventMapper;
import com.event.manager.repository.EventRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository repository;
    private final GatewayClient gateway;


    public Event createNewEvent(EventDTO request) {
        Event event = EventMapper.INSTANCE.toEvent(request);
        var address = gateway.getAddress(event.getCep());
        event.setLogradouro(address.logradouro());
        event.setUf(address.uf());
        event.setBairro(address.bairro());
        event.setLocalidade(address.localidade());
        event.setCep(address.cep());
        return repository.save(event);
    }

    public Event findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("the event is not registered in our database"));
    }

    public List<Event> findAllEvents() {
        return repository.findAll();
    }

    public List<Event> findByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }
}
