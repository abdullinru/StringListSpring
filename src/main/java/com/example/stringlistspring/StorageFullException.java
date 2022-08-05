package com.example.stringlistspring;

public class StorageFullException extends RuntimeException {
    public StorageFullException(String s) {
        super(s);
    }
}
