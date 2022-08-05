package com.example.stringlistspring;

public class ElementNullException extends RuntimeException {
    public ElementNullException(String element_is_null) {
        super(element_is_null);
    }
}
