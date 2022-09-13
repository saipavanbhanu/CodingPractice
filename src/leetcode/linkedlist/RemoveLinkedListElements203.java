package leetcode.linkedlist;

public class RemoveLinkedListElements203 {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
	class Solution {
		public ListNode removeElements(ListNode head, int val) {
			if (head == null) {
				return null;
			}
			ListNode iter = head;
			ListNode result = null;
			ListNode resultTail = null;
			while (iter != null) {
				if (iter.val == val) {
					ListNode next = iter.next;
					iter.next = null;
					iter = next;
				} else {
					if (result == null) {
						result = iter;
						resultTail = iter;
						iter = iter.next;
						resultTail.next = null;
					} else {
						ListNode next = iter.next;
						resultTail.next = iter;
						resultTail = iter;
						resultTail.next = null;
						iter = next;
					}
				}
			}
			return result;
		}
	}
}
