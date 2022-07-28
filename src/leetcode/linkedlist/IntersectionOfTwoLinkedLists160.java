package leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class IntersectionOfTwoLinkedLists160 {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; next = null; } }
	 */
	public class Solution {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			Deque<ListNode> st1 = new ArrayDeque<>();
			while (headA != null) {
				st1.push(headA);
				headA = headA.next;
			}

			Deque<ListNode> st2 = new ArrayDeque<>();
			while (headB != null) {
				st2.push(headB);
				headB = headB.next;
			}

			ListNode result = null;
			while (!st1.isEmpty() && !st2.isEmpty()) {
				ListNode first = st1.pop();
				ListNode second = st2.pop();
				if (first == second) {
					result = first;
				} else {
					break;
				}
			}
			return result;
		}
	}
}
