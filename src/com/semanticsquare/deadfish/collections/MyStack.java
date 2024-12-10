package com.semanticsquare.deadfish.collections;

public class MyStack<T> implements Stack<T>{
	private Object[] stack;
	private int size;
	 
 public MyStack() {
	 stack = new Object[10];
	 size = 0;
	 
 }

@Override
public void push(Object item) {
	if(size == stack.length){
		resize();
	}
	stack[size++] = item;
}

private void resize() {
	Object[] newStack = new Object[stack.length * 2];
	
	for(int i = 0; i < stack.length; i++) {
		newStack[i] = stack[i];
	}
	stack = (T[]) newStack;
}

@Override
public T pop() {
    if (isEmpty()) {
        throw new IllegalStateException("Stack is empty.");
    }	
    
    T item = (T)stack[--size];
    stack[size] = null;
    return item;
  
    }

@Override
public T peek() {
    if (isEmpty()) {
        throw new IllegalStateException("Stack is empty.");
    }
    return (T) stack[size - 1];
}

@Override
public boolean isEmpty() {
	return size == 0;
}

@Override
public int size() {
	return size;
}
}
