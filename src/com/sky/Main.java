package com.sky;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        //...
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            //...
        } finally {
            lock.unlock();
        }
    }
}
