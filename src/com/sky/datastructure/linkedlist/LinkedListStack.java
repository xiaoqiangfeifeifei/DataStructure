package com.sky.datastructure.linkedlist;

import com.sky.datastructure.stack.Stack;

/***
 * @ProjectName DataStructure
 * @Title: LinkedListStack
 * @Description:
 * @author Sky
 * @date 2020/1/23 18:16
 * @Version V1.0.0
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }


    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty(E e) {
        return list.getSize() == 0;
    }

    @Override
    public int getSize() {
        return list.getSize();
    }
}
