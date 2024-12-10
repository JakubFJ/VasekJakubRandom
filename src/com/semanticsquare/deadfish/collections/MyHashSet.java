package com.semanticsquare.deadfish.collections;


public class MyHashSet<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double LOAD_FACTOR = 0.75;  
    private T[] table;
    private int size;

    public MyHashSet() {
        table = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

   
    private int hash1(T element) {
        return Math.abs(element.hashCode()) % table.length;
    }

  
    private int hash2(T element) {
        return 1 + (Math.abs(element.hashCode()) % (table.length - 2)); 
    }

  
    private void checkLoadFactor() {
        if ((double) size / table.length > LOAD_FACTOR) {
            resize();
        }
    }

    
    private void resize() {
        T[] oldTable = table;
        table = (T[]) new Object[table.length * 2];  
        size = 0;

       
        for (T element : oldTable) {
            if (element != null) {
                add(element);  
            }
        }
    }

    
    public void add(T element) {
        checkLoadFactor();

        int index = hash1(element);
        int step = hash2(element);

        while (table[index] != null) {
            if (addElementAtIndex(index, element)) {
                return;
            }

            index = (index + step) % table.length;

            if (addElementAtIndex(index, element)) {
                return;
            }

            index = (index - step + table.length) % table.length;

            if (addElementAtIndex(index, element)) {
                return;
            }
        }

        table[index] = element;
        size++;
    }

    
    public boolean contains(T element) {
        int index = hash1(element);
        int step = hash2(element);

        int attempts = 0;

        while (table[index] != null && attempts < table.length) {
            if (containsElementAtIndex(index, element)) {
                return true;
            }

            index = (index + step) % table.length;

            if (containsElementAtIndex(index, element)) {
                return true;
            }

            index = (index - step + table.length) % table.length;

            if (containsElementAtIndex(index, element)) {
                return true;
            }

            attempts++;
        }
        return false;
    }
    
    public void remove(T element) {
        int index = hash1(element);
        int step = hash2(element);

        int attempts = 0;

        while (table[index] != null && attempts < table.length) {
            if (removeElementAtIndex(index, element)) {
                return;
            }

            index = (index + step) % table.length;

            if (removeElementAtIndex(index, element)) {
                return;
            }

            index = (index - step + table.length) % table.length;

            if (removeElementAtIndex(index, element)) {
                return;
            }

            attempts++;
        }
    }
    
    private boolean addElementAtIndex(int index, T element) {
        if (table[index] != null && table[index].equals(element)) {
            return true;
        }
        return false;
    }
    
    private boolean containsElementAtIndex(int index, T element) {
        return table[index] != null && table[index].equals(element);
    }

    private boolean removeElementAtIndex(int index, T element) {
        if (table[index] != null && table[index].equals(element)) {
            table[index] = null;
            size--;
            return true;
        }
        return false;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

