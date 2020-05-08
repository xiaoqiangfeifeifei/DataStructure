package com.sky.algorithm.interview.simple.linkedlist;

import java.util.HashMap;

/**
 * 复制含有随机指针节点的链表
 * 【题目】 一种特殊的链表节点类描述如下：
 * public class Node { public int value; public Node next; public Node rand; public Node(int data) { this.value = data; } }
 * Node类中的value是节点值，next指针和正常单链表中next指针的意义 一 样，都指向下一个节点，rand指针是Node类中新增的指针，
 * 这个指 针可 能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由 Node节点类型组成的无环单链表的头节点head，请实现一个 函数完成 这个链表中所有结构的复制，并返回复制的新链表的头节点。
 * 进阶： 不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N) 内完成原问题要实现的函数。
 */
public class CopyListWithRandom {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next =  new Node(2);
        node1.next.next = new Node(3);

        node1.rand = node1.next.next;
        node1.next.rand = node1.next.next;
        node1.next.next.rand = null;

        printNodeList(node1);
        Node newHead = copyListWithRandom2(node1);
        printNodeList(newHead);

    }

    private static void printNodeList(Node head) {
        System.out.print("Order:");
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }

        System.out.print("Rand:");
        cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.rand;
        }
    }


    public static class Node {
        public int value;
        public Node next;
        public Node rand;
        public Node(int data) {
            this.value = data;
        }
    }

    public static Node copyListWithRandom1(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> hashMap = new HashMap();

        Node cur = head;
        while (cur != null) {
            hashMap.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).rand = hashMap.get(cur.rand);
            cur = cur.next;
        }

        return hashMap.get(head);
    }

    public static Node copyListWithRandom2(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Node next = null;
        //复制节点放到当前节点的后面
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        //将复制节点的rand指针关联上
        cur = head;
        Node copyNode = null;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            copyNode.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        //断开节点
        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            cur.next = next;
            copyNode.next = next != null ? next.next : null;

            cur = next;
        }

        return res;
    }



}
