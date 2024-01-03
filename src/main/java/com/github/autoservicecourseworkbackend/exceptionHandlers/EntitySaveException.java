package com.github.autoservicecourseworkbackend.exceptionHandlers;

public class EntitySaveException extends RuntimeException{

    public EntitySaveException(String message) {
        super(message);
    }
}
