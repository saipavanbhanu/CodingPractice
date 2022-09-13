package leetcode.linkedlist;

public class IntersectionOfTwoLinkedLists160 {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; next = null; } }
	 */
	public class Solution {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			int count1 = 0;
			ListNode iter1 = headA;
			while (iter1 != null) {
				count1++;
				iter1 = iter1.next;
			}

			int count2 = 0;
			ListNode iter2 = headB;
			while (iter2 != null) {
				count2++;
				iter2 = iter2.next;
			}

			if (count1 < count2) {
				iter2 = headB;
				iter1 = headA;
				int diff = count2 - count1;
				while (diff > 0) {
					iter2 = iter2.next;
					diff--;
				}
			} else {
				iter2 = headB;
				iter1 = headA;
				int diff = count1 - count2;
				while (diff > 0) {
					iter1 = iter1.next;
					diff--;
				}
			}

			while (iter1 != null && iter2 != null) {
				if (iter1 == iter2) {
					return iter1;
				}
				iter1 = iter1.next;
				iter2 = iter2.next;
			}

			return null;
		}
	}
}
