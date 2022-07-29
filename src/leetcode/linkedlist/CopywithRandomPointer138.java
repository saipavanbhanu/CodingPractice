package leetcode.linkedlist;

public class CopywithRandomPointer138 {

	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	class Solution {
		void print(Node head) {
			Node iter = head;
			while (iter != null) {
				System.out.print(iter.val + ",");
				iter = iter.next;
			}
			System.out.println();
		}

		void printR(Node head) {
			System.out.println("Random");
			Node iter = head;
			while (iter != null) {
				System.out.print(iter.val + ",");
				iter = iter.random;
			}
			System.out.println();
		}

		public Node copyRandomList(Node head) {
			if (head == null) {
				return head;
			}
			// copy the node next to the original node
			Node iter = head;
			while (iter != null) {
				Node copy = new Node(iter.val);
				copy.next = iter.next;
				iter.next = copy;
				iter = copy.next;
			}
			// print(head);

			// set the random pointer to the one in copied nodes.
			Node copyHead = head.next;
			iter = head;
			while (iter != null) {
				// System.out.print(iter.val+",");
				if (iter.random != null)
					iter.next.random = iter.random.next;
				iter = iter.next.next;
			}
			// printR(copyHead);
			// remove the copied nodes from the original list
			iter = head;
			while (iter != null) {
				Node copy = iter.next;
				iter.next = iter.next.next;
				if (copy.next != null)
					copy.next = copy.next.next;
				iter = iter.next;
			}

			return copyHead;
		}
	}
}
