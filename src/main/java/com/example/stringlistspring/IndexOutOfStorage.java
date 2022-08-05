package com.example.stringlistspring;

public class IndexOutOfStorage extends RuntimeException {
    public IndexOutOfStorage(String index_is_false) {
        super(index_is_false);
    }
}
