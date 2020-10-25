package com.sky.algorithm.interview.simple.tree;


/**
 * 求完全二叉树的数量，要求时间复杂度小于0(n)
 *
 * @ClassName: CompleteTreeNodeNumber
 * @Author Administrator
 * @Date 2020/10/25
 * @Version 1.0
 */
public class CompleteTreeNodeNumber {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }


    /**
     *
     * @param head 当前头结点
     * @param level 当前节点处于层数
     * @param amountLevel 当前树的最大层数
     * @return
     */
    private static int bs (Node head, int level, int amountLevel) {
        if (level == amountLevel) {//当前层到了最后一层，代表叶节点
            return 1;
        }
        //如果右子树到了最后一层，说明左子树是满二叉树, 左子树层数为 总层数 - 当前层
        if (mostLeftLevel(head.right, level + 1) == amountLevel) {
            return (1 << (amountLevel - level)) - 1 + 1 + bs(head.right, level + 1, amountLevel);
        } else {
            return (1 << (amountLevel - level - 1)) - 1 + 1 + bs(head.left, level + 1, amountLevel);
        }
    }


    private static int mostLeftLevel(Node head, int level) {
       while (head != null) {
           level++;
           head = head.left;
       }

        return level - 1;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }
}
