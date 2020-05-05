package com.sky.algorithm.interview.simple.linkedlist;

/**
 * 反转单向和双向链表 【题目】 分别实现反转单向链表和反转双向链表的函数。
 * 【要求】 如果链表长度为N，时间复杂度要求为O(N)，额外空间 复杂度要求为O(1)
 *
 * @ClassName: RevertList
 * @Author Administrator
 * @Date 2020/5/4
 * @Version 1.0
 */
public class RevertList {
    public static void main(String[] args) {
//        Node head1 = new Node(1);
//        head1.next = new Node(2);
//        head1.next.next = new Node(3);
//        printLinkedList(head1);
//        head1 = revertNode(head1);
//        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(revertNode(head2));
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    /**
     * 反转单向链表
     * @param head
     * @return
     */
    public static Node revertNode(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static DoubleNode revertNode(DoubleNode head) {
        DoubleNode next = null;
        DoubleNode pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;

            pre = head;
            head = next;
        }

        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.println("linked list: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static  void printDoubleLinkedList(DoubleNode head) {
        System.out.println("Double linked list: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }

        System.out.println("/");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }

        System.out.println();
    }




}
