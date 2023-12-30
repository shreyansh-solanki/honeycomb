package com.honeycomb.Exceptions;

public class DataIntegrityViolationException extends RuntimeException{

    public DataIntegrityViolationException() {
        super("Duplicate key value violates unique constraint !!");
    }

    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
