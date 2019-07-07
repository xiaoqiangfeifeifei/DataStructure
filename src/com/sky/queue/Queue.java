package com.sky.queue;

public interface Queue<T> {
    int getSize();
    boolean isEmpty();
    void enqueue(T t);
    T dequeue();
    T getFront();
}
