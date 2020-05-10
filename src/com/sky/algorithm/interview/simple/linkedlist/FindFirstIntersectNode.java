package com.sky.algorithm.interview.simple.linkedlist;


/**
 * 两个单链表相交的一系列问题
 * 【题目】 在本题中，单链表可能有环，也可能无环。给定两个 单链表的头节点 head1和head2，这两个链表可能相交，也可能 不相交。
 * 请实现一个函数， 如果两个链表相交，请返回相交的 第一个节点；如果不相交，返回null 即可。
 * 要求：如果链表1 的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外 空间复杂度请达到O(1)。
 */
public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next = head1.next;

        Node loopNode = getLoopNode(head1);
        System.out.println(loopNode);
    }

    public static Node getFirstIntersect(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        // 两条链表都不存在环， 普通链表相交
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        // 两条链表都存在环， 环链表相交
        if (loop1 != null && loop2 != null) {
            return loop(loop1, loop2, head1, head2);
        }
        //普通链表与环链表， 不相交
        return null;
    }

    /**
     * 找到有环链表相交
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node loop(Node loop1, Node loop2, Node head1, Node head2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {//其实就是无环链表的查找相交节点的逻辑
            cur1 = head1;
            cur2 = head2;

            int n = 0;
            while (cur1.next != loop1) {//一直循环loop1
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop1) {//一直循环loop2
                n--;
                cur2 = cur2.next;
            }

            //此时cur1 cur2是loop节点。 对于有环节点来说， 一定是cur1=cur2
            cur1 = n > 0 ? head1 : head2;//长链表头
            cur2 = cur1 == head1 ? head2 : head1;//短链表头

            n = Math.abs(n);
            while (n != 0) {
                cur1 = cur1.next;
                n--;
            }

            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1;

            while (cur1 != null) {
                if (cur1 == loop2) {
                    return cur1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }


    /**
     * 找到单链表的环节点
     *
     * @param head
     * @return
     */
    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            //如果遇到空节点，说明不是环
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;

    }

    /**
     * 获取两个无环节点的第一个相交节点
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node cur1 = head1;
        Node cur2 = head2;

        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //此时cur1 cur2是尾节点
        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2;//长链表头
        cur2 = cur1 == head1 ? head2 : head1;//短链表头

        n = Math.abs(n);
        while (n != 0) {
            cur1 = cur1.next;
            n--;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
