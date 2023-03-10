package com.capstone.mini.petini.handlers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.capstone.mini.petini.handlers.exceptions.DuplicateException;
import com.capstone.mini.petini.handlers.exceptions.InvalidException;
import com.capstone.mini.petini.handlers.exceptions.NotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseMessage notFoundException(NotFoundException exc, WebRequest web) {
        return new ResponseMessage(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND.value(), new Date(),
                exc.getMessage(), web.getDescription(false));
    }

    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseMessage invalidException(InvalidException exc, WebRequest web) {
        return new ResponseMessage(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST.value(), new Date(),
                exc.getMessage(), web.getDescription(false));
    }

    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ResponseMessage duplicateException(DuplicateException exc, WebRequest web) {
        return new ResponseMessage(HttpStatus.CONFLICT.getReasonPhrase(), HttpStatus.CONFLICT.value(), new Date(),
                exc.getMessage(), web.getDescription(false));
    }
}
