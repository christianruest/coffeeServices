package com.cr.coffee.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidIdException extends RuntimeException {

    public InvalidIdException(Long id){
        super("Invalid ID: " + id.toString());
    }

    public InvalidIdException(String id) {
        super("Invalid ID: " + id);
    }
}

