package com.cr.coffee.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRefDataException extends RuntimeException {
    public InvalidRefDataException(String message) {
        super("Invalid refdata: " + message);
    }

}
