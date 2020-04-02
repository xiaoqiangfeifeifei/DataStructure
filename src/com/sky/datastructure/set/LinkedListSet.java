package com.sky.datastructure.set;

import com.sky.datastructure.linkedlist.LinkedList;

/***
 * @ProjectName DataStructure
 * @Title: LinkedListSet
 * @Description:
 * @author Sky
 * @date 2020/2/4 21:51
 * @Version V1.0.0
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeFirst();// todo linkedList暂时未实现移除指定元素方法
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
