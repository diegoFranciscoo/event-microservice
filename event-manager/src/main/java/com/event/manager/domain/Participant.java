package com.event.manager.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "participants")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

}
