package com.event.manager.exception.ParticipantExeception;

import com.event.manager.exception.ExceptionDetails;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ParticipantIsAlreadyRegisteredExceptionDetails extends ExceptionDetails {
}
