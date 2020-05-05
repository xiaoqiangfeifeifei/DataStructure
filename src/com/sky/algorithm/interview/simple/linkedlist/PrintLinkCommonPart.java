package com.sky.algorithm.interview.simple.linkedlist;

/**
 * 打印两个有序链表的公共部分
 * 【题目】 给定两个有序链表的头指针head1和head2，打印两个 链表的公共部分。
 *
 * @ClassName: PrintLinkCommonPart
 * @Author Administrator
 * @Date 2020/5/4
 * @Version 1.0
 */
public class PrintLinkCommonPart {

    public static void main(String[] args) {

    }

    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    public void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value > head2.value) {
                head2 = head2.next;
            } else if (head1.value < head2.value) {
                head1 = head2.next;
            } else {
                System.out.println("head value:" + head1.value);

                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
