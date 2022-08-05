package com.example.stringlistspring;

public class StringListIsNull extends RuntimeException {
    public StringListIsNull(String otherList_is_null) {
        super(otherList_is_null);
    }
}
