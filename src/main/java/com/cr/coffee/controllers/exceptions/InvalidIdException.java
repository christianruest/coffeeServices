package com.cr.coffee.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotNull;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidIdException extends RuntimeException {

    public InvalidIdException(@NotNull Long id){
        super("Invalid ID: " + id.toString());
    }

    public InvalidIdException(String id) {
        super("Invalid ID: " + id);
    }
}

