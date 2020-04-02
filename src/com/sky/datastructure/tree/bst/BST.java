package com.sky.datastructure.tree.bst;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/***
 * @ProjectName DataStructure
 * @Title: BST(Binary Search Tree)
 * @Description:
 * @author Sky
 * @date 2020/2/3 15:50
 * @Version V1.0.0
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

//    // 向二分搜索树中添加元素e
//    public void add(E e) {
//        if (this.root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(this.root, e);
//        }
//    }
//
//    // 向以node为根的二分搜索树添加元素E,递归算法
//    private void add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {//根元素小于待添加元素，并且左孩子为空，直接将左孩子指向当前元素
//            node.left = new Node(e);
//            size++;
//            return;
//        }else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else {
//            add(node.right, e);
//        }
//    }

    // 向二分搜索树中添加元素e
    public void add(E e) {
        root = add(this.root, e);
    }


    //将元素插入当前节点下，返回二叉树的根节点
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    //看二叉搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // 二叉搜索树的前序遍历
    public void preOrder() {
        preOrder(this.root);
    }

    //前序遍历以node为根的二叉搜索树， 递归算法
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 二叉搜索树前序遍历（非递归实现）
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            // 先压入右子树，先进后出，右子树后遍历
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // 二叉搜索树的中序遍历
    public void inOrder() {
        inOrder(this.root);
    }

    //中序遍历以node为根的二叉搜索树， 递归算法
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二叉搜索树的后序遍历
    public void postOrder() {
        postOrder(this.root);
    }

    //后序遍历以node为根的二叉搜索树， 递归算法
    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二叉树的层序遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            System.out.println(cur.e);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }


    //寻找二分搜索树最小值
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(this.root).e;
    }

    // 返回node为根的二分搜索树的最小值所在节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    // 删除二分搜索树中的最小值所在节点，返回最小值
    public E removeMin() {
        E ret = minimum();
        this.root = removeMin(this.root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中最小节点
    //返回删除节点后的新二分搜索树的跟根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node retNode = node.right;
            node.right = null;
            size--;
            return retNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //寻找二分搜索树最大值
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(this.root).e;
    }

    // 返回node为根的二分搜索树的最大值所在节点
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    //删除掉以node为根的二分搜索树中最大节点
    //返回删除节点后的新二分搜索树的跟根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node retNode = node.left;
            node.left = null;
            return retNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 删除二分搜索树中指定元素
    public void remove(E e){
        this.root = remove(this.root, e);
    }

    // 删除以node为根的二分搜索树中的e值
    // 返回删除节点后的根节点
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 左右子树均不为空的情况
            // 找到比被删除节点大的最小元素（后继元素），替换待删除节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(this.root, 0, sb);
        return sb.toString();
    }

    //生成以node为节点，深度为depth的搜索二叉树字符串
    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
