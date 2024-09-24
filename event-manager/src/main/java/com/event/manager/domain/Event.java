package com.event.manager.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;
    private String title;
    private String description;
    private String date;

    @Column(nullable = false)
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    @ManyToMany
    @JoinTable(
            name = "participant_event",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    List<Participant> participants = new ArrayList<>();
}
