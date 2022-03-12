package com.example.twoApi.exception_handling;

public class NoSuchBookException extends RuntimeException{
    private String id;

    public NoSuchBookException(String id){
        this.id = id;
    }
    @Override
    public String getMessage(){
        return "Бро, сорри, записи по переданному id = " + id + " не найдены";
    }
}
