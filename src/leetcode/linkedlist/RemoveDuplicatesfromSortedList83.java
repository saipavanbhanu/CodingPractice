package leetcode.linkedlist;

public class RemoveDuplicatesfromSortedList83 {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
	class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			if (head == null) {
				return head;
			}
			ListNode iter = head;
			while (iter != null) {
				if (iter.next != null && iter.val == iter.next.val) {
					ListNode start = iter;
					ListNode end = iter.next;
					ListNode prev = end;
					while (end != null && start.val == end.val) {
						prev = end;
						end = end.next;
					}
					if (prev != null) {
						start.next = prev.next;
						prev.next = null;
					}
				}
				iter = iter.next;
			}
			return head;
		}
	}
}
