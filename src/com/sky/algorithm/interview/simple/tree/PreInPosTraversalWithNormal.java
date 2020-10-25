package com.sky.algorithm.interview.simple.tree;


import com.sky.algorithm.interview.simple.tree.util.PrintBinaryTree;

import javax.sound.midi.SoundbankResource;
import java.util.Stack;

/**
 * 二叉树前中后 遍历 (非递归版本的)
 *
 * @ClassName: PreInPosTraversal
 * @Author Administrator
 * @Date 2020/5/11
 * @Version 1.0
 */
public class PreInPosTraversalWithNormal {
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


        printTree(node1);
        inOrderNoRecur(node1);

    }

    /**
     * 前序遍历
     *
     * @param head
     */
    private static void preOrderNoRecur(Node head) {
        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node printNode = stack.pop();
            System.out.println(printNode.value);

            if (printNode.right != null) {
                stack.push(printNode.right);
            }
            if (printNode.left != null) {
                stack.push(printNode.left);
            }
        }
    }


    /**
     * 中序遍历
     * @param head
     */
    private static void inOrderNoRecur(Node head) {

        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }


    /**
     * 后序遍历（左右中）， 先存储 中右左，再逆序打印
     * @param head
     */
    private static void afterOrderNoRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Stack<Node> printStack = new Stack<>();
            stack.push(head);

            while (!stack.isEmpty()) {
                head = stack.pop();
                printStack.push(head);//暂时不打印，先压进栈

                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }

            while (!printStack.isEmpty()) {
                Node pop = printStack.pop();
                System.out.println(pop.value);
            }
        }
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
