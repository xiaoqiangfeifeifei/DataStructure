package com.sky;

import com.sky.array.Array;
import com.sky.stack.ArrayStack;

public class Main {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();

        for (int i = 0; i < 5 ; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
