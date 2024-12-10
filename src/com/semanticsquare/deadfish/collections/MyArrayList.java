package com.semanticsquare.deadfish.collections;

import java.util.Arrays;

public class MyArrayList<T> implements List<T> {
    private T[] array;
    private int size;
    private MyStack<T> availableFreeSpace;

    public MyArrayList() {
        array = (T[]) new Object[10];
        size = 0;
        availableFreeSpace = new MyStack<>();
    }

    @Override
    public void add(T element) {
    if(availableFreeSpace.isEmpty()) {
    	if(size == array.length) {
    		resize();
    	}
    	array[size++] = element;
    } else {
    	int index = (int) availableFreeSpace.pop();
    	array[index] = element;
    	}
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T[] toArray() {
        Integer[] newArray = new Integer[size];
        
        for (int i = 0; i < size; i++) {
            newArray[i] = (Integer) array[i]; 
        }

        return (T[]) newArray;
    }

    @Override
    public void remove(int index) {
    	
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        array[index] = null;
        availableFreeSpace.push(index);
       
        size--;
    }
    
    private void resize() {
        Object[] newArray = new Object[array.length * 2];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        
        array = (T[]) newArray;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

}