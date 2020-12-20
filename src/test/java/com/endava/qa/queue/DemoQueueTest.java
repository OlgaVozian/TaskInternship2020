package com.endava.qa.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class DemoQueueTest {

    DemoQueue<String> queue;

    @BeforeEach
    void initializeQueue() {
        queue = new DemoQueue(4);
    }

    @Test
    void addElement() {
        queue.addElement("1");
        Assertions.assertEquals(1, queue.size(), "There should be 1 element in queue");
        queue.addElement("2");
        Assertions.assertEquals(2, queue.size(), "There should be 2 element in queue");
        queue.addElement("3");
        queue.addElement("4");
        Assertions.assertFalse(queue.addElement("5"), "add element should return false when queue is full");
        Assertions.assertEquals(4, queue.size(), "There should be 4 element in queue");
    }

    @Test
    void poll() {
        queue.addElement("1");
        queue.addElement("2");
        queue.addElement("3");
        Assertions.assertEquals(queue.poll(), "1");
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    void remove() {
        Assertions.assertThrows(NoSuchElementException.class, () -> queue.remove(),"Should throw an exception when try to remove from empty queue");
        queue.addElement("1");
        queue.addElement("2");
        queue.remove();
        Assertions.assertEquals(1, queue.size(), "There should be 1 element in queue");
    }

    @Test
    void element() {
        Assertions.assertThrows(NoSuchElementException.class, () -> queue.element(),"Should throw an exception when try to remove from empty queue");
        queue.addElement("1");
        queue.addElement("2");
        Assertions.assertEquals("1", queue.element());
        Assertions.assertEquals(2, queue.size(), "There should be 2 element in queue");
    }

    @Test
    void size() {
        queue.addElement("1");
        Assertions.assertEquals(1, queue.size(), "There should be 1 element in queue");
    }

    @Test
    void clear() {
        queue.addElement("1");
        Assertions.assertEquals(1, queue.size(), "There should be 1 element in queue");
        queue.clear();
        Assertions.assertEquals(0, queue.size(), "The queue should be empty after clear");
    }

    @Test
    void contains() {
        queue.addElement("1");
        Assertions.assertTrue(queue.contains("1"), "The queue should contain element 1");
        Assertions.assertFalse(queue.contains("2"), "The queue should not contain element 2");
    }
}
