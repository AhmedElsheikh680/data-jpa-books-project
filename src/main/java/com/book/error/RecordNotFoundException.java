package com.book.error;

public class RecordNotFoundException extends RuntimeException{
    
    public RecordNotFoundException(String message) {
        super(message);
    }
}
