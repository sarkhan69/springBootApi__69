package com.example.twoApi.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleException(NoSuchBookException exception) {
        BookIncorrectData data = new BookIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity handleException(Exception exception) {
        BookIncorrectData data = new BookIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity(data, HttpStatus.BAD_REQUEST);
    }
}
