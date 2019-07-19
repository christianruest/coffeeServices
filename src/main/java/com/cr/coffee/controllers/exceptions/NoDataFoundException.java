package com.cr.coffee.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException(Long id){
        super("No data found with id: " + id.toString());
    }

}
