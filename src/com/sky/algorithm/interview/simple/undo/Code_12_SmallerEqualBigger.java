package com.sky.algorithm.interview.simple.undo;


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
 */
public class Code_12_SmallerEqualBigger {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node listPartition1(Node head, int pivot) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		Node[] nodeArr = new Node[i];
		i = 0;
		cur = head;
		for (i = 0; i != nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodeArr, pivot);
		for (i = 1; i != nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i - 1].next = null;
		return nodeArr[0];
	}

	public static void arrPartition(Node[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {
			if (nodeArr[index].value < pivot) {
				swap(nodeArr, ++small, index++);
			} else if (nodeArr[index].value == pivot) {
				index++;
			} else {
				swap(nodeArr, --big, index);
			}
		}
	}

	public static void swap(Node[] nodeArr, int a, int b) {
		Node tmp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = tmp;
	}

	public static Node listPartition2(Node head, int pivot) {
		Node sH = null; // small head
		Node sT = null; // small tail
		Node eH = null; // equal head
		Node eT = null; // equal tail
		Node bH = null; // big head
		Node bT = null; // big tail
		Node next = null; // save next node
		// every node distributed to three lists
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
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
		// small and equal reconnect
		if (sT != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		// all reconnect
		if (eT != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH != null ? eH : bH;
	}

	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(9);
		head1.next = new Node(0);
		head1.next.next = new Node(4);
		head1.next.next.next = new Node(5);
		head1.next.next.next.next = new Node(1);
		printLinkedList(head1);
		 head1 = listPartition1(head1, 3);
//		head1 = listPartition2(head1, 5);
//		printLinkedList(head1);

	}

}
