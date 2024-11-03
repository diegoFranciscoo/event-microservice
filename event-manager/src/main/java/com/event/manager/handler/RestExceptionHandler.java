package com.event.manager.handler;

import com.event.manager.exception.EventException.EventDoesNotExistsException;
import com.event.manager.exception.EventException.EventDoesNotExistsExceptionDetails;
import com.event.manager.exception.ParticipantExeception.ParticipantDoesNotExistsException;
import com.event.manager.exception.ParticipantExeception.ParticipantDoesNotExistsExceptionDetails;
import com.event.manager.exception.ParticipantExeception.ParticipantIsAlreadyRegisteredException;
import com.event.manager.exception.ParticipantExeception.ParticipantIsAlreadyRegisteredExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EventDoesNotExistsException.class)
    private ResponseEntity<EventDoesNotExistsExceptionDetails> handlerEventDoesNotExists(EventDoesNotExistsException e) {
        return new ResponseEntity<>(EventDoesNotExistsExceptionDetails
                .builder()
                .title("Event does not exists")
                .details(e.getMessage())
                .timestamp(LocalDateTime.now())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ParticipantDoesNotExistsException.class)
    private ResponseEntity<ParticipantDoesNotExistsExceptionDetails> handlerEventDoesNotExists(ParticipantDoesNotExistsException e) {
        return new ResponseEntity<>(ParticipantDoesNotExistsExceptionDetails
                .builder()
                .title("Participant does not exists")
                .details(e.getMessage())
                .timestamp(LocalDateTime.now())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ParticipantIsAlreadyRegisteredException.class)
    private ResponseEntity<ParticipantIsAlreadyRegisteredExceptionDetails> handlerEventDoesNotExists(ParticipantIsAlreadyRegisteredException e) {
        return new ResponseEntity<>(ParticipantIsAlreadyRegisteredExceptionDetails
                .builder()
                .title("the participant is already registered for the event")
                .details(e.getMessage())
                .timestamp(LocalDateTime.now())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build(), HttpStatus.BAD_REQUEST);
    }
}
