package com.honeycomb.Exceptions;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException() {
        super("Resource not found on server !!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}