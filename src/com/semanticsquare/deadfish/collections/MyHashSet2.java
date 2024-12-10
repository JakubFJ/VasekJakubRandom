package com.semanticsquare.deadfish.collections;

import java.util.Objects;

public class MyHashSet2<T> {
    private Object[] table;
    private int size;
    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_CAPACITY = 10;
    private final Hasher<T> hasher;
    
    public MyHashSet2(Hasher<T> hasher, int capacity) {
    	this.table = new Object[capacity];
    	this.size = 0;
        this.hasher = hasher;
    }
    
    public MyHashSet2() {
        this(new RealHasher<>());
    }

    public MyHashSet2(Hasher<T> hasher) {
    	this(hasher, DEFAULT_CAPACITY);
    }

    public boolean add(T element) {
        checkLoadFactor();
        int originalIndex = Math.abs(hasher.getHashCode(element) % table.length);
        int index = originalIndex;
        int step = 1;

        while (true) {
            if (table[index] == null) {
                table[index] = element;
                size++;
                return true;
            } else if (table[index].equals(element)) {
                return false;
            }

            if (index == 0) {
                index = calculateNextIndexRight(originalIndex, step++);
            } else if (index == table.length - 1) {
                index = calculateNextIndexLeft(originalIndex, step++);
            } else {
                index = calculateNextIndex(originalIndex, step++);
            }

            index %= table.length;
        }
    }

    private int calculateNextIndex(int originalIndex, int step) {
        return (step % 2 == 0)
                ? originalIndex - step / 2
                : originalIndex + (step + 1) / 2;
    }

    private int calculateNextIndexRight(int originalIndex, int step) {
        return originalIndex + step;
    }

    private int calculateNextIndexLeft(int originalIndex, int step) {
        return originalIndex - step;
    }

    private void resize() {
        T[] oldTable = (T[]) table;
        table = new Object[table.length * 2];
        size = 0;

        for (T element : oldTable) {
            if (element != null) {
                add(element);
            }
        }
    }

    private void checkLoadFactor() {
        if ((double) size / table.length > LOAD_FACTOR) {
            resize();
        }
    }

    public boolean contains(T element) {
        int originalIndex = Math.abs(hasher.getHashCode(element) % table.length);
        int index = originalIndex;
        int step = 1;

        while (table[index] != null) {
            if (table[index].equals(element)) {
                return true;
            }
            index = calculateNextIndex(originalIndex, step++);
            index %= table.length;
        }

        return false;
    }

    public int size() {
        return size;
    }
}
