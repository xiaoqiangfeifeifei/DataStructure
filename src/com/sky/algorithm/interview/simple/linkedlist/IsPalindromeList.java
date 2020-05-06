package com.sky.algorithm.interview.simple.linkedlist;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构 【题目】 给定一个链表的头节点head，请判断该链表是否为回 文结构。
 * 例如： 1->2->1，返回true。 1->2->2->1，返回true。 15->6->15，返回true。 1->2->3，返回false。
 *
 * 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂 度达到O(1)
 */
public class IsPalindromeList {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(3);
        node.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next = new Node(1);


    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    // need n extra space
    public static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack();
        Node cur = head;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    // need n/2 extra space
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node cur = head;
        Node right = head.next;
        while (cur.next != null && cur.next.next !=null) {
            cur = cur.next.next;
            right = right.next;
        }

        Stack<Node> stack = new Stack();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {//此处需要用stack来判断，stack只包含一半数据
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    // need O(1) extra space
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        //找到中间位置指针
        Node cur = head;//快指针
        Node mid = head;//慢指针，移动到中间位置
        while (cur.next != null && cur.next.next !=null) {
            cur = cur.next.next;
            mid = mid.next;
        }

        //翻转后半部分链表
        cur = mid.next;//右链表的第一个节点
        mid.next = null;//中间节点指向null

        Node next = null;
        Node pre = mid;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        //比较两个链表
        cur = head;
        Node right = pre;//右边链表的最后一个节点
        boolean res = true;
        while (cur != null && right != null) {
            if (cur.value != right.value) {
                res = false;
                break;
            }
            cur = cur.next;
            right = right.next;
        }

        //还原链表
        Node cur1 = pre.next;//当前节点为倒数第二个节点
        pre.next = null;//最后一个节点指向null
        Node next1 = null;
        Node pre1 = pre;
        while (cur1 != null) {
            next1 = cur1.next;
            cur1.next = pre1;
            pre1 = cur1;
            cur1 = next1;
        }

        return res;

    }

}
