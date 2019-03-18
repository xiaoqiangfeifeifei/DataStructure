package com.sky;

import com.sky.array.Array;

public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();

        for (int i = 0; i < arr.getCapacity(); i++) {
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.set(1, 10000);
        System.out.println(arr);

        arr.remove(1);
        System.out.println(arr);

        arr.removeElement(15);
        System.out.println(arr);
    }
}
