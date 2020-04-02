package com.sky.datastructure.linkedlist;

/***  
 * @ProjectName DataStructure
 * @Title: LinkedList
 * @Description:
 * @author Sky
 * @date 2020/1/5 20:59
 * @Version V1.0.0
 */
public class LinkedList<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node dummyHead;
    private int size;


    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中元素的个数
    public int getSize() {
        return size;
    }
    // 返回链表是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }


    // 在链表的index位置添加新的元素
    public void add( int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;// index位置的前一个元素
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表头添加新的元素
    public void addFirst (E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        this.add(0, e);
    }

    // 在链表的尾部添加元素
    public void addLast(E e) {
        add(size, e);
    }

    // 查找链表的index位置元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i =0; i< index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获取链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改指定位置的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表是否包含元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e.equals(cur.e)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }


    // 删除指定位置元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Del failed. Illegal index.");
        }
        Node pre = dummyHead;
        for (int i = 0 ; i < index; i++) {
            pre = pre.next;
        }

        Node retNode = pre.next;
        pre.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;

    }

    // 删除链表头元素
    public E removeFirst() {
        return this.remove(0);
    }

    // 删除链表尾元素
    public E removeLast() {
        return this.remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur + "->");
        }
        sb.append("NULL");

        return sb.toString();
    }


}
