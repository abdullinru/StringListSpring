package com.example.stringlistspring;

import java.util.Arrays;

public class StringArrayList implements StringList {
    private int size;
    private String[] storage;

    public StringArrayList(int amount) {
        storage = new String[amount];
        size = 0;
    }
    public StringArrayList(String [] stringMas) {
        storage = stringMas;
        size = stringMas.length;
    }


    @Override
    public String add(String item) {
        if (item == null) {
            throw new ElementNullException("Element is NULL");
        }
        if (size == storage.length) {
            String[] newStorage = new String[storage.length*2];
            for (int i = 0; i < size; i++) {
                newStorage[i] = storage[i];
            }
            storage = newStorage;
//            throw new StorageFullException("Storage is  full");
        }
        storage[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new ElementNullException("Element is NULL");
        }
        if (size == storage.length) {
            String[] newStorage = new String[storage.length*2];
            System.arraycopy(storage, 0, newStorage, 0, size);
            storage = newStorage;
//            throw new StorageFullException("Storage is  full");
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfStorage("Index is false");
        }
        for (int i = size; i != index; i--) {
            storage[i] = storage[i - 1];
        }
        storage[index] = item;
        size++;

        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new ElementNullException("Element is NULL");
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfStorage("Index is false");
        }
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new ElementNullException("Element is NULL");
        }
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new ElementMissingInStorage("Element is not found");
        }

        for (int i = index; i < size-1; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfStorage("Index is false");
        }
        String result = storage[index];
        for (int i = index; i < size-1; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
        return result;
    }

    @Override
    public boolean contains(String item) {

        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {

        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1; i > 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfStorage("Index is false");
        }
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new StringListIsNull("otherList is NULL");
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i] != otherList.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = null;
        result = Arrays.copyOf(storage, size);

        return result;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + storage[i]);
        }
    }
}
