package com.sky.algorithm.interview.simple.linkedlist;


/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 【题目】 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个 整 数pivot。
 * 实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot 的节点，中间部分都是值等于pivot的节点，右部分都是值大于 pivot的节点。
 * 除这个要求外，对调整后的节点顺序没有更多的要求。 例如：链表9->0->4->5- >1，pivot=3。
 * 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总 之，满 足左部分都是小于3的节点，
 * 中间部分都是等于3的节点（本例中这个部 分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做 要求
 *
 * 进阶： 在原问题的要求之上再增加如下两个要求。 在左、中、右三个部分的内部也做顺序要求，
 * 要求每部分里的节点从左 到右的 顺序与原链表中节点的先后次序一致。 例如：链表9->0->4->5->1，pivot=3。 调整后的链表是0->1->9->4->5。
 * 在满足原问题要求的同时，左部分节点从左到 右为0、1。在原链表中也 是先出现0，后出现1；中间部分在本例中为空，不再 讨论；
 * 右部分节点 从左到右为9、4、5。在原链表中也是先出现9，然后出现4， 最后出现5。
 * 如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)
 *
 *
 * @ClassName: SmallerEqualBiggerList
 * @Author Administrator
 * @Date 2020/5/6
 * @Version 1.0
 */
public class SmallerEqualBiggerList {
    public static void main(String[] args) {
        Node node = new Node(9);
        node.next = new Node(0);
        node.next.next = new Node(4);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(1);

        Node head = listPartition2(node, 3);
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
        }

    }
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static  Node listPartition1(Node head, int num) {
        if (head == null) {
            return null;
        }

        int i = 0;
        Node cur = head;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodes = new Node[i];
        cur = head;
        for (int j = 0; j <nodes.length ; j++) {
            nodes[j] = cur;
            cur = cur.next;
        }

        Node[] sortedNodes = partition(nodes,  num);

        int j = 1;
        for (; j < sortedNodes.length ; j++) {
            sortedNodes[j - 1].next = sortedNodes[j];
        }
        sortedNodes[j - 1].next = null;//防止sort中node本身next就包含引用，需要将引用置为空
        return sortedNodes[0];
    }

    private static Node listPartition2(Node head, int num) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;

        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < num) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == num) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        //将小 中 大三条链表链接
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    private static Node[] partition(Node[] nodes, int num) {
        if (nodes == null) {
            return null;
        }
        int less = -1;
        int more = nodes.length;
        int cur = 0;
        while (cur < more) {
            if (nodes[cur].value < num)  {
                swap(nodes, ++less, cur++);//将less后一位（less先移动，所以用++less）与cur交换， cur移动到下一个位置(所以用cur++)
            } else if (nodes[cur].value > num) {
                swap(nodes, --more, cur);
            } else {
                cur++;
            }
        }

        return nodes;
    }

    public static Node[] swap(Node [] arr, int x, int y) {
        Node temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return arr;
    }

}
