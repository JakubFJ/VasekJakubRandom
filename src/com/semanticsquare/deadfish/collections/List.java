package com.semanticsquare.deadfish.collections;

public interface List<T> {
    int size();                  
    T[] toArray();   
    void add(T element);    
    T get(int index);                   
    void remove(int index);
}
