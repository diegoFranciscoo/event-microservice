package com.event.manager.exception.ParticipantExeception;

public class ParticipantIsAlreadyRegisteredException extends RuntimeException {
    public ParticipantIsAlreadyRegisteredException(String message) {
        super(message);
    }
}
