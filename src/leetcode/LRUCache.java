package leetcode;

import java.util.HashMap;
import java.util.Map;
class LRUCache {
	DLL list;
	Map<Integer, DLNode> map;
	int capacity;
	public LRUCache(int capacity) {
		list = new DLL();
		map = new HashMap<Integer, DLNode>();
		this.capacity = capacity;
	}
	public int get(int key) {
		DLNode node = map.get(key);
		if (node == null) {
			return -1;
		} else {
			list.delete(node);
			list.insert(node);
			map.put(node.key, node);
			return node.value;
		}
	}
	public void put(int key, int value) {
		DLNode node = map.get(key);
		if (node == null) {
			node = new DLNode(key, value);
			if (list.size < capacity) {
				list.insert(node);
			} else {
				list.insert(node);
				DLNode deletedNode = list.delete(list.tail);
				map.remove(deletedNode.key);
			}
			map.put(key, node);
		} else {
			DLNode deletedNode = list.delete(node);
			list.insert(deletedNode);
            deletedNode.value = value;
			map.put(key, deletedNode);
		}
	}
}

class DLNode {
	int key, value;
	DLNode prev, next;
	DLNode(int key, int value) {
		this.key = key;
		this.value = value;
		prev = next = null;
	}
	public String toString() {
		return "(" + key + "," + value + ")";
	}
}

class DLL {
	DLNode head, tail;
	int size;
	DLL() {
		size = 0;
		head = tail = null;
	}
	DLNode search(int key) {
		DLNode trav = head;
		while (trav != null) {
			if (trav.key == key) {
				return trav;
			}
			trav = trav.next;
		}
		return null;
	}

	void insert(DLNode node) {
		if (head == null && tail == null) {
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		size++;
	}

	DLNode delete(DLNode node) {
		if (head == tail) {
			head = tail = null;
		} else if (node.prev == null) {
			head = head.next;
			head.prev = null;
		} else if (node.next == null) {
			tail = tail.prev;
			tail.next = null;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		size--;
		node.next = null;
		node.prev = null;
		//printList();
		return node;
	}

	// void printList() {
	// 	DLNode node = head;
	// 	while (node != null) {
	// 		node = node.next;
	// 	}
	// 	node = tail;
	// 	while (node != null) {
	// 		node = node.prev;
	// 	}
	// }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */