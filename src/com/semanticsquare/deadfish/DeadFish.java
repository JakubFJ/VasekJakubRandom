package com.semanticsquare.deadfish;

import com.semanticsquare.deadfish.collections.HasherStub;
import com.semanticsquare.deadfish.collections.MyArrayList;
import com.semanticsquare.deadfish.collections.MyHashSet;
import com.semanticsquare.deadfish.collections.MyHashSet2;
import com.semanticsquare.deadfish.collections.MySet;
import com.semanticsquare.deadfish.collections.MyStack;

public class DeadFish {

    public static Integer[] parse(String data) {
        int count = 0;
        MyArrayList<Integer> deadfishArrayList = new MyArrayList<>(); 
        MySet<Integer> deadfishSet = new MySet<>();

        for (char deadfish : data.toCharArray()) {
            switch (deadfish) {
                case 'i':
                    count++;
                    break;
                case 'd':
                    count--;
                    break;
                case 's':
                    count = count * count;
                    break; 
                case 'o':
                	deadfishArrayList.add(count);
                    break;
                default:
                    break;
            }
        }

        return deadfishArrayList.toArray();   
        
    }

    public static void main(String[] args) {
        // Testing MySet
      /*  System.out.println("Test for MySet:");
        
        // Create MySet instance
        MySet<Integer> deadfishSet = new MySet<>();
        
        // Add elements
        System.out.println("Adding elements to MySet:");
        deadfishSet.add(10);  // Should be added
        deadfishSet.add(20);  // Should be added
        deadfishSet.add(30);  // Should be added
        
        // Check content and size
        System.out.println("MySet content after adding 10, 20, and 30:");
        Integer[] setArray = deadfishSet.toArray(Integer.class);
        for (int num : setArray) {
            System.out.println(num); // Expected: 10, 20, 30
        }
        
        // Check size and if set is empty
        System.out.println("Size of the set: " + deadfishSet.size()); // Expected: 3
        System.out.println("Is the set empty? " + deadfishSet.isEmpty()); // Expected: false
        
        // Try adding a duplicate (should be ignored)
        deadfishSet.add(20);
        System.out.println("After trying to add a duplicate (20), the set should stay the same:");
        setArray = deadfishSet.toArray(Integer.class);
        for (int num : setArray) {
            System.out.println(num); // Expected: 10, 20, 30
        }
        
        // Remove an element
        deadfishSet.remove(20);
        System.out.println("After removing 20:");
        setArray = deadfishSet.toArray(Integer.class);
        for (int num : setArray) {
            System.out.println(num); // Expected: 10, 30
        }
        
        // Check size and emptiness after removal
        System.out.println("Size of the set after removing 20: " + deadfishSet.size()); // Expected: 2
        System.out.println("Is the set empty after removal? " + deadfishSet.isEmpty()); // Expected: false
        
        // Testing the parse method (from the DeadFish class)
        System.out.println("Test for the parse method:");
        String program = "iiisdoso";
        Integer[] result = parse(program);
        
        System.out.println("Result for MyArrayList:");
        for (int i : result) {
            System.out.println(i); // Expected: 81, 81 (counting with arrayList values)
        }

        // Testing MyStack
        MyStack<Integer> stack = new MyStack<>();

        // Test push method
        System.out.println("Adding elements to the stack:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Test peek method (getting the top element without removing it)
        System.out.println("Top element after several pushes (peek): " + stack.peek()); // Expected: 40

        // Test pop method (removing the top element)
        System.out.println("Popping elements from the stack:");
        System.out.println("Popped element: " + stack.pop()); // Expected: 40
        System.out.println("Popped element: " + stack.pop()); // Expected: 30

        // Test isEmpty method
        System.out.println("Is the stack empty? " + stack.isEmpty()); // Expected: false

        // Test size method
        System.out.println("Size of the stack: " + stack.size()); // Expected: 2

        // Pop more elements
        System.out.println("Popped element: " + stack.pop()); // Expected: 20
        System.out.println("Popped element: " + stack.pop()); // Expected: 10

        // Test when the stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty()); // Expected: true */
    	/*
    	 MyHashSet<Integer> set = new MyHashSet<>();

         // Test 1: Přidání prvku a kontrola, zda je v sadě
         set.add(10);
         System.out.println("Test 1: Test add(10) a contains(10)");
         System.out.println("Contains 10: " + set.contains(10));  // Očekáváme true
         System.out.println();

         // Test 2: Odstranění prvku a kontrola, zda je odstraněn
         set.remove(10);
         System.out.println("Test 2: Test remove(10) a contains(10) po odstranění");
         System.out.println("Contains 10: " + set.contains(10));  // Očekáváme false
         System.out.println();

         // Test 3: Kontrola velikosti sady
         System.out.println("Test 3: Test size() po přidání a odstranění prvků");
         set.add(20);
         set.add(30);
         System.out.println("Size: " + set.size());  // Očekáváme 2 (20, 30)
         System.out.println();

         // Test 4: Kontrola prázdnosti sady
         System.out.println("Test 4: Test isEmpty() před a po odstranění prvků");
         System.out.println("Is empty before removal: " + set.isEmpty());  // Očekáváme false
         set.remove(20);
         set.remove(30);
         System.out.println("Is empty after removal: " + set.isEmpty());  // Očekáváme true
         System.out.println();

         // Test 5: Přidání duplikátu
         System.out.println("Test 5: Test add(20) a přidání stejného prvku");
         set.add(20);
         set.add(20);  // Sada by neměla umožnit duplikáty
         System.out.println("Contains 20: " + set.contains(20));  // Očekáváme true
         System.out.println("Size after adding duplicate: " + set.size());  // Očekáváme 1 (nikoli 2)
         System.out.println();

         // Test 6: Rehashování
         System.out.println("Test 6: Test rehashování (přidání dostatečného počtu prvků)");
         for (int i = 0; i < 8; i++) {
             set.add(i);  // Spustí rehashování, protože po 8 prvcích tabulka překročí limit
         }
         System.out.println("Size after rehashing: " + set.size());  // Očekáváme 9
         for (int i = 0; i < 8; i++) {
             System.out.println("Contains " + i + ": " + set.contains(i));  // Očekáváme true pro všechny prvky 0-7
         }
         System.out.println();
         */
         
         /* MyHashSet2<Integer> myHashSet = new MyHashSet2<>();

         // Test 1: Přidávání prvků
         System.out.println("Adding elements...");
         System.out.println("Add 10: " + myHashSet.add(10)); // true
         System.out.println("Add 20: " + myHashSet.add(20)); // true
         System.out.println("Add 30: " + myHashSet.add(30)); // true
         System.out.println("Add 10 again: " + myHashSet.add(10)); // false (duplicate)

         // Test 2: Kontrola existence
         System.out.println("\nChecking elements...");
         System.out.println("Contains 10: " + myHashSet.contains(10)); // true
         System.out.println("Contains 20: " + myHashSet.contains(20)); // true
         System.out.println("Contains 40: " + myHashSet.contains(40)); // false

         // Test 3: Přetečení a automatické zvětšení
         System.out.println("\nAdding more elements to trigger resize...");
         for (int i = 1; i <= 15; i++) {
             myHashSet.add(i * 10); // Add 10, 20, ..., 150
         }
         System.out.println("Size after adding 15 elements: " + myHashSet.size()); // Size should match added unique elements
         System.out.println("Contains 100: " + myHashSet.contains(100)); // true
         System.out.println("Contains 200: " + myHashSet.contains(200)); // false

         // Test 4: Kontrola integrity po resize
         System.out.println("\nChecking integrity after resize...");
         System.out.println("Contains 10: " + myHashSet.contains(10)); // true
         System.out.println("Contains 150: " + myHashSet.contains(150)); // true
         System.out.println("Contains 160: " + myHashSet.contains(160)); // false

         // Závěrečný výstup
         System.out.println("\nFinal size: " + myHashSet.size()); */
    	
    	testWithRealHasher();
        testWithHasherStub();
     }
    public static void testWithRealHasher() {
        System.out.println("Test with RealHasher:");
        MyHashSet2<String> set = new MyHashSet2<>();

        // Přidání prvků
        System.out.println("Add 'hello': " + set.add("hello")); // true
        System.out.println("Add 'world': " + set.add("world")); // true
        System.out.println("Add 'hello' again: " + set.add("hello")); // false (duplicate)

        // Kontrola existence
        System.out.println("Contains 'hello': " + set.contains("hello")); // true
        System.out.println("Contains 'world': " + set.contains("world")); // true
        System.out.println("Contains 'java': " + set.contains("java")); // false

        // Kontrola velikosti
        System.out.println("Size: " + set.size()); // 2
        System.out.println();
    }

    // Test s předvídatelným HasherStub
    public static void testWithHasherStub() {
        System.out.println("Test with HasherStub:");
        MyHashSet2<Integer> set = new MyHashSet2<>(new HasherStub<>());

        // Přidání prvků
        System.out.println("Add 5: " + set.add(5)); // true
        System.out.println("Add 15 (collision): " + set.add(15)); // true
        System.out.println("Add 5 again: " + set.add(5)); // false (duplicate)
        System.out.println("Add 15 again: " + set.add(15)); //false (duplicate)
 
        // Kontrola existence
        System.out.println("Contains 5: " + set.contains(5)); // true
        System.out.println("Contains 15: " + set.contains(15)); // true
        System.out.println("Contains 10: " + set.contains(10)); // false

        // Kontrola kolizí a integrity
        System.out.println("Add 25 (collision): " + set.add(25)); // true
        System.out.println("Contains 25: " + set.contains(25)); // true

        // Kontrola velikosti
        System.out.println("Size: " + set.size()); // 3 nebo více, podle implementace
        System.out.println();
    }
    }

