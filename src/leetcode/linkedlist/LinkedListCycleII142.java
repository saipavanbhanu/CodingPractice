package leetcode.linkedlist;

public class LinkedListCycleII142 {
	/**
	 * Definition for singly-linked list. class ListNode { int val; ListNode next;
	 * ListNode(int x) { val = x; next = null; } }
	 */
	public class Solution {
		public ListNode detectCycle(ListNode head) {
			if (head == null || head.next == null) {
				return null;
			}

			ListNode slow, fast;
			slow = fast = head;
			do {
				slow = slow.next;
				fast = fast.next.next;
			} while (!(fast == null || fast.next == null) && slow != fast);
			if (slow == fast) {
				// System.out.println(slow.val);
				slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			} else {
				return null;
			}
		}
	}
}
