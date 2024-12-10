package com.semanticsquare.deadfish.collections;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyHashSet2Test {

    private MyHashSet2<Integer> set;

    @BeforeEach
    public void setUp() {
        set = new MyHashSet2<>(new HasherStub<>());
    }

    @Test
    void shouldAddElementAndContains() {
        addAndVerify(5); // Adds and verifies the element
    }

    @Test
    void shouldAddDuplicateElement() {
        addAndVerify(5); // Add the first time
        assertFalse(set.add(5), "Adding duplicate 5 should return false"); // Add duplicate
        assertTrue(set.contains(5), "Set should still contain 5"); // Verify element is still present
    }

    @Test
    void shouldResolveCollisionsBothDirections() {
        givenSetCapacity(10); // Set smaller capacity to easily simulate collisions

        addAndVerify(5);   // Expected index: 5 (no collision)
        addAndVerify(15);  // Collision → Resolved by moving right to index 6
        addAndVerify(-5);  // Collision → Resolved by moving left to index 4
        addAndVerify(-15); // Collision → Resolved by further moving left to index 3
    }

    @Test
    void shouldResize() {
        // Add elements to exceed the initial capacity and trigger a resize
        for (int i = 0; i < 20; i++) {
            addAndVerify(i);
        }

        // Verify all elements are still in the set after resizing
        for (int i = 0; i < 20; i++) {
            assertTrue(set.contains(i), "Set should contain " + i);
        }

        // Verify the size of the set
        assertEquals(20, set.size(), "Set size should be 20 after adding 20 unique elements");
    }

    // Helper method: Adds an element and verifies it was added successfully
    private void addAndVerify(int element) {
        assertTrue(set.add(element), "Adding element " + element + " should return true");
        assertTrue(set.contains(element), "Set should contain element " + element);
    }

    // Helper method: Sets the initial capacity of the set for testing purposes
    private void givenSetCapacity(int capacity) {
        set = new MyHashSet2<>(new HasherStub<>(), capacity);
    }
}
