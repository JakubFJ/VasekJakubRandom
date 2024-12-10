package com.semanticsquare.deadfish.collections;
import java.util.Iterator;


public class MySet<T> implements Set<T> {
    private static final int DEFAULT_CAPACITY = 10; 
    private MyLinkedList<T>[] table;
    private int size;

    public MySet() {
        table = new MyLinkedList[DEFAULT_CAPACITY];
        size = 0;

        for (int i = 0; i < table.length; i++) {
            table[i] = new MyLinkedList<>();
        }
    }

    @Override
    public void add(T element) {
        int index = getIndex(element);
        MyLinkedList<T> list = table[index];

        if (!list.contains(element)) {
            list.add(element);
            size++;
        }
    }

    @Override
    public void remove(T element) {
        int index = getIndex(element);
        MyLinkedList<T> list = table[index];

        if (list.remove(element)) {
            size--;
        }
    }

    @Override
    public boolean contains(T element) {
        int index = getIndex(element);
        MyLinkedList<T> list = table[index];
        return list.contains(element);
    }

    private int getIndex(T element) {
        return Math.abs(element.hashCode()) % table.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        MyLinkedList<T>[] newTable = new MyLinkedList[table.length * 2];
        for (int i = 0; i < newTable.length; i++) {
            newTable[i] = new MyLinkedList<>();  // Vytvoříme nový MyLinkedList pro každý index
        }

        for (MyLinkedList<T> list : table) {  // Procházíme všechny seznamy ve staré tabulce
            for (T element : list) {  // Procházíme prvky v každém seznamu
                int index = Math.abs(element.hashCode()) % newTable.length;
                newTable[index].add(element);  // Přidáme prvek do nové tabulky
            }
        }

        table = newTable;  // Aktualizujeme tabulku na novou (větší)
    }

    // Metoda pro převod sady na pole
    public T[] toArray(Class<T> clazz) {
        T[] result = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
        int i = 0;
        for (MyLinkedList<T> list : table) {  // Procházíme všechny seznamy v tabulce
            for (T element : list) {  // Procházíme prvky v každém seznamu
                result[i++] = element;  // Přidáme prvek do výsledného pole
            }
        }
        return result;  // Vrátíme pole obsahující všechny prvky
    }
}
