package com.sky.linkedlist.leetcode;

/***  
 * @ProjectName DataStructure
 * @Title: Solution
 * @Description:
 * @author Sky
 * @date 2020/1/27 13:33
 * @Version V1.0.0
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 直接通过dummyHead遍历节点
        ListNode prev = dummyHead;
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

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 6, 7, 8, 9};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        new Solution2().removeElements(head, 6);
        System.out.println(head);
    }
}
