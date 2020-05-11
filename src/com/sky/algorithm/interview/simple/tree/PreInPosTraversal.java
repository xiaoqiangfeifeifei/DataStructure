package com.sky.algorithm.interview.simple.tree;

import com.sky.algorithm.interview.simple.undo.Code_01_PreInPosTraversal;

/**
 * 二叉树前中后 遍历
 *
 * @ClassName: PreInPosTraversal
 * @Author Administrator
 * @Date 2020/5/11
 * @Version 1.0
 */
public class PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;


        preOrderRecur(node1);
        System.out.println();
        inOrderRecur(node1);
        System.out.println();
        posOrderRecur(node1);
    }


    private static void preOrderNoRecur(Node head) {
        if (head != null) {
            
        }
    }


    private static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    private static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value);
        inOrderRecur(head.right);
    }
    private static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value);
    }



}
