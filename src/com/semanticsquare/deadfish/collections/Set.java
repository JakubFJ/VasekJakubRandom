package com.semanticsquare.deadfish.collections;

public interface Set<T> {
    void add(T element);        
    void remove(T element);     
    boolean contains(T element); 
    int size();                 
    boolean isEmpty();          
}         
