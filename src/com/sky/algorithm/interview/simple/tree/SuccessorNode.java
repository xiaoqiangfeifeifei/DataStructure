package com.sky.algorithm.interview.simple.tree;



/**
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 * 假 设有一 棵Node类型的节点组成的二叉树，树中每个节点的parent指针 都正确地指向 自己的父节点，头节点的parent指向null。
 * 只给一个在 二叉树中的某个节点 node，请实现返回node的后继节点的函数。
 * 在二 叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。
 * @ClassName: SuccessorNode
 * @Author Administrator
 * @Date 2020/10/11
 * @Version 1.0
 */
public class SuccessorNode {


    /**
     * 获取当前节点的后继节点
     * @return
     */
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }

        if (node.right != null) {
            //获取当前右子树的最左节点
            return getLeftMost(node.right);
        } else {
            //当前节点无右子树，找到以当前为左子树的第一个元素
            Node p = node.parent;
            while (p != null && node != p.left) {
                node = p;
                p = p.parent;
            }
            return p;
        }
    }


    private static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    private static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node (int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }
}
