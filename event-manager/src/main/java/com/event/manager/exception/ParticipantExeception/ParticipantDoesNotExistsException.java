package com.event.manager.exception.ParticipantExeception;

public class ParticipantDoesNotExistsException extends RuntimeException{
    public ParticipantDoesNotExistsException(String message) {
        super(message);
    }
}
