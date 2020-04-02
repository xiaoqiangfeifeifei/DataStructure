package com.sky.datastructure.linkedlist.leetcode;

/***  
 * @ProjectName DataStructure
 * @Title: Solution3
 * @Description:
 * @author Sky
 * @date 2020/1/28 19:19
 * @Version V1.0.0
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
//        ListNode res = removeElements(head.next, val);
//        // 删除的节点就是头结点，返回res节点
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 6, 7, 8, 9};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        new Solution2().removeElements(head, 6);
        System.out.println(head);
    }
}
