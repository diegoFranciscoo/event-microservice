package com.event.manager.exception.EventException;

import com.event.manager.exception.ExceptionDetails;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class EventDoesNotExistsExceptionDetails extends ExceptionDetails{
}
