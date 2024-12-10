package com.semanticsquare.deadfish;

public interface MySet<T> {
    void add(T element);
    void remove(T element);
    boolean contains(T element);
    int size();
    boolean isEmpty();
}

