package com.example.twoApi.exception_handling;

public class NoSuchBookException extends RuntimeException{
    public NoSuchBookException(String message) {
        super(message);
    }
}
