package com.cr.coffee.utils;

import com.cr.coffee.controllers.exceptions.NoDataFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNoDataFoundExceptionMethod(NoDataFoundException ex, WebRequest request) {

        ExceptionMessage exceptionMessageObj = new ExceptionMessage();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        exceptionMessageObj.setMessage(ex.getLocalizedMessage());
        exceptionMessageObj.setError(ex.getClass().getCanonicalName());
        exceptionMessageObj.setPath(((ServletWebRequest) request).getRequest().getServletPath());
        exceptionMessageObj.setStatus(httpStatus.value());

        return new ResponseEntity<>(exceptionMessageObj, httpStatus);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionMessage exceptionMessageObj = new ExceptionMessage();
        HttpStatus httpStatus = status;

        String errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(x -> x.getDefaultMessage())
            .collect(Collectors.toList())
            .toString();

        exceptionMessageObj.setError(errors);
        exceptionMessageObj.setMessage(ex.getMessage());
        exceptionMessageObj.setPath(((ServletWebRequest) request).getRequest().getServletPath());
        exceptionMessageObj.setStatus(status.value());

        return new ResponseEntity<>(exceptionMessageObj, headers, status);
    }

}
