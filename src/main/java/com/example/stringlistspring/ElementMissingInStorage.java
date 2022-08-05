package com.example.stringlistspring;

public class ElementMissingInStorage extends RuntimeException {
    public ElementMissingInStorage(String element_is_not_found) {
        super(element_is_not_found);
    }
}
