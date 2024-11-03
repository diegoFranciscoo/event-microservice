package com.event.manager.exception.EventException;

public class EventDoesNotExistsException extends RuntimeException {
    public EventDoesNotExistsException(String message) {
        super(message);
    }
}
