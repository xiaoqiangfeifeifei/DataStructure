package com.sky.algorithm.interview.simple.tree;


/**
 * 判断一个树是否为平衡二叉树（左右子树高度差不超过1）
 *
 * @ClassName: IsBanlanceTree
 * @Author Administrator
 * @Date 2020/10/18
 * @Version 1.0
 */
public class IsBalanceTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    private static class Result {
        //当前树的高度
        private int h;
        //当前树是否为平衡二叉树
        private boolean isB;

        public Result( boolean isB, int h) {
            this.h = h;
            this.isB = isB;
        }
    }


    public static boolean isBalance(Node head) {
        return  processData(head).isB;
    }

    private static Result processData(Node head) {
        if (head == null) {
            return new Result(true,0 );
        }
        //处理左子树
        Result lResult = processData(head.left);
        if (!lResult.isB) {
            return new Result(false,0 );
        }
        //处理右子树
        Result rResult = processData(head.right);
        if (!rResult.isB) {
            return new Result(false,0 );
        }

        //左右子树高度差超过1，则不是平衡二叉树
        if (Math.abs(lResult.h- rResult.h) > 1) {
            return new Result(false,0 );
        }
        //返回当前树的高度，即左子树、右子树中最大值加1
        return new Result(true, Math.max(lResult.h , rResult.h) + 1);
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }
}
