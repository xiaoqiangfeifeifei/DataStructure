package com.sky.datastructure.linkedlist;

import com.sky.datastructure.queue.Queue;

/***
 * @ProjectName DataStructure
 * @Title: LinkedListQueue
 * @Description:
 * @author Sky
 * @date 2020/1/23 22:12
 * @Version V1.0.0
 */
public class LinkedListQueue<E> implements Queue<E> {
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

    private Node head, tail;
    private int size;


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        // tail 为空代表整个队列为空
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            // 将链表尾部新增一个节点
            tail.next = new Node(e);
            // 将tail指针移动到最后一位，也就是tail.next
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue from an empty queue");
        }

        //1. 构造返回值，指向当前head
        Node retNode = head;
        //2. 将队列尾部向后移一位
        head = head.next;
        if (head == null) {
            // 如果是最后一位元素，当出队完成时，此时队列为空，tail还指向前一个出队的元素，需要手动设置为null
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue from an empty queue");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (Node cur = head.next; cur != null; cur = cur.next) {
            sb.append(cur + "->");
        }
        sb.append("NULL");

        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue linkedList = new LinkedListQueue();
        for (int i = 0; i < 5; i++) {
            linkedList.enqueue(i);
            System.out.println(linkedList);
        }


        linkedList.dequeue();
        System.out.println(linkedList);
    }

}
