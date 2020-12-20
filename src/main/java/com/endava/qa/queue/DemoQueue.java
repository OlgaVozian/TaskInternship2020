package com.endava.qa.queue;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DemoQueue<T> {

    public int cursor, size;
    private List<T> queue;

    public DemoQueue(int size) {
        this.size = size;
        this.queue = new ArrayList<>(size);
    }

    public boolean addElement(T elementToAdd) {
        if (cursor == size) {
            return false;
        }
        queue.add(elementToAdd);
        cursor++;
        return true;
    }

    public T poll() {
        if (queue.isEmpty()) {
            return null;
        }
        T element = queue.get(0);
        queue.remove(0);
        cursor--;
        return element;
    }

    public T remove() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Empty queue");
        }
        T element = queue.get(0);
        queue.remove(0);
        cursor--;
        return element;
    }

    public T element() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Empty queue");
        }
        return queue.get(0);
    }

    public int size() {
        return cursor;
    }

    public void clear() {
        cursor = 0;
        queue.clear();
    }

    public boolean contains(T t) {
        for (T element : queue) {
            if (element.equals(t)) {
                return true;
            }
        }
        return false;
    }

}

