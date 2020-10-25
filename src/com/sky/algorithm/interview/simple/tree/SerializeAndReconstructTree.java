package com.sky.algorithm.interview.simple.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化并且反序列化二叉树
 *
 * @ClassName: SerializeAndReconstructTree
 * @Author Administrator
 * @Date 2020/10/11
 * @Version 1.0
 */
public class SerializeAndReconstructTree {
    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 序列化二叉树（前序遍历）
     * @param node
     * @return
     */
    public static String serialByPre(Node node) {
        if (node == null) {
            return "#_";
        }

        String res = node.value + "_";
        res += serialByPre(node.left);
        res += serialByPre(node.right);
        return res;
    }

    /**
     * 反序列化二叉树（前序遍历）
     * @param nodeStr
     * @return
     */
    public static Node reconByPreString (String nodeStr) {
        if (nodeStr == null) {
            return null;
        }
        String[] nodeStrs = nodeStr.split("_");

        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i< nodeStrs.length; i++) {
            queue.offer(nodeStrs[i]);
        }

        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }


    // for test -- print tree
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


    public static void main(String[] args) {
        Node head = null;
        printTree(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);


        System.out.println("====================================");

        head = new Node(1);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);



        System.out.println("====================================");

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);


        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        System.out.println("====================================");

    }
}
