package com.sky.stack;

import com.sky.array.Array;

/***
 * @ProjectName DataStructure
 * @Title: ArrayStack
 * @Description:
 * @author Sky
 * @date 2019/5/26 23:43
 * @Version V1.0.0
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public  ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }
    public  ArrayStack() {
        array = new Array<>();
    }


    private int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public boolean isEmpty(E e) {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("stack: [");
        for (int i = 0; i< array.getSize(); i++) {
            res.append(array.get(i));

            if (i != array.getSize() - 1) {
                res.append(", ");
            }

        }
        res.append(" ] top");
        return res.toString();
    }
}
