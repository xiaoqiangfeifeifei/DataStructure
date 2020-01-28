package com.sky.linkedlist.leetcode;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

import java.util.List;

/***
 * @ProjectName DataStructure
 * @Title: ListNode
 * @Description:
 * @author Sky
 * @date 2020/1/27 13:41
 * @Version V1.0.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }

    ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("array can't be empty");
        }

        this.val = arr[0];
        ListNode cur = this;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        ListNode cur = this;
        while (cur.next != null) {
            sb.append(cur.val);
            sb.append("->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
