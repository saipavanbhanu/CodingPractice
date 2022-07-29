package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

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
		public Node copyRandomList(Node head) {
			if (head == null) {
				return head;
			}

			Map<Node, Node> map = new HashMap<>(1000);
			Node iter = head;
			while (iter != null) {
				map.put(iter, new Node(iter.val));
				iter = iter.next;
			}

			iter = head;
			while (iter != null) {
				Node copy = map.get(iter);
				copy.next = map.get(iter.next);
				copy.random = map.get(iter.random);
				iter = iter.next;
			}

			return map.get(head);
		}
	}
}
