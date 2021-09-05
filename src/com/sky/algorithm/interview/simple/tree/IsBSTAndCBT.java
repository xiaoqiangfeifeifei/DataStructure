package com.sky.algorithm.interview.simple.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName: IsBSTAnd
 * @Author Administrator
 * @Date 2020/10/19
 * @Version 1.0
 */
public class IsBSTAndCBT {
    private static class Node  {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 判断一棵树是否为搜索树
     * 左边都比根节点小， 右边都比根节点大
     *
     * @return
     */
    public static boolean isBST(Node head) {
        if (head != null) {
            Node lastNode = new Node(Integer.MIN_VALUE);
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    if (lastNode.value > head.value) {
                        return false;
                    }
                    lastNode = head;
                    head = head.right;
                }
            }
        }

        return true;
    }


    /**
     * 判断一颗树是否为完全二叉树
     * <p>
     * 依次从左往右排
     *
     * @param head
     * @return
     */
    private static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }

        boolean isLeaf = false;
        Node l = null;
        Node r = null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();

            l = pollNode.left;
            r = pollNode.right;

            //左空又不空 或者 开启叶子节点，但是遇到非叶子节点
            if ((l == null && r != null)  || (isLeaf && (l != null || r != null))) {
                return false;
            }

            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }

            //左右节点不全的情况，开启叶子节点
            if (l == null || r == null) {
                isLeaf = true;
            }

        }

        return true;

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
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }

}
