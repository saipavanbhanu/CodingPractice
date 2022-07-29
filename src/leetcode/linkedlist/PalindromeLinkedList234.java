package leetcode.linkedlist;

public class PalindromeLinkedList234 {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
	class Solution {
		public boolean isPalindrome(ListNode head) {
			if (head == null || head.next == null) {
				return true;
			}
			int len = length(head);
			ListNode second = divide(head, len);
			return compare(head, reverse(second));
		}

		boolean compare(ListNode head1, ListNode head2) {
			if (head1 == null && head2 == null) {
				return true;
			} else if ((head1 == null && head2 != null) || (head1 != null && head2 == null)) {
				return false;
			} else {
				while (head1 != null && head2 != null) {
					if (head1.val != head2.val) {
						return false;
					}
					head1 = head1.next;
					head2 = head2.next;
				}
				return true;
			}
		}

		ListNode reverse(ListNode head) {
			ListNode result = null;
			ListNode iter = head;
			ListNode temp = null;
			while (iter != null) {
				temp = iter.next;
				if (result == null) {
					result = iter;
				} else {
					iter.next = result;
					result = iter;
				}
				iter = temp;
			}
			return result;
		}

		ListNode divide(ListNode head, int len) {
			if (len % 2 == 0) {
				int times = len / 2 - 1;
				ListNode iter = head;
				while (times > 0) {
					iter = iter.next;
					times--;
				}
				ListNode second = iter.next;
				iter.next = null;
				return second;
			} else {
				int times = len / 2 - 1;
				ListNode iter = head;
				while (times > 0) {
					iter = iter.next;
					times--;
				}
				ListNode second = iter.next.next;
				iter.next.next = null;
				iter.next = null;
				return second;
			}
		}

		int length(ListNode head) {
			ListNode iter = head;
			int count = 0;
			while (iter != null) {
				count++;
				iter = iter.next;
			}
			return count;
		}

	}
}
