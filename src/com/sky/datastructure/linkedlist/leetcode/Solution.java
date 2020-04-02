package com.sky.datastructure.linkedlist.leetcode;

/***  
 * @ProjectName DataStructure
 * @Title: Solution
 * @Description:
 * @author Sky
 * @date 2020/1/27 13:33
 * @Version V1.0.0
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 首先判断头结点是否存在满足被删除的情况
        while (head != null && head.val == val) {
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        // 判断中间节点存在满足条件的情况
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }
}
