package com.bo.coding.base;


public class Pair<E, F> {
    private E key;
    private F value;

    public Pair(E key, F value) {
        this.key = key;
        this.value = value;
    }

    public E getKey() {
        return key;
    }

    public F getValue() {
        return value;
    }
}
