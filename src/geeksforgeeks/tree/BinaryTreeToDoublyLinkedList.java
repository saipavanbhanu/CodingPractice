package geeksforgeeks.tree;

import geeksforgeeks.tree.binarytree.Node;

public class BinaryTreeToDoublyLinkedList {
	Node root;
	Node head, tail;
	
	// Driver program to test above functions
	public static void main(String[] args) {
		// Let us create the tree as shown in above diagram
		BinaryTreeToDoublyLinkedList tree = new BinaryTreeToDoublyLinkedList();
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);

		// convert to DLL
		tree.BinaryTree2DoubleLinkedList(tree.root);

		// Print the converted List
		tree.printList(tree.head);

	}

	private void BinaryTree2DoubleLinkedList(Node node) {
		if(node == null)
			return;
		
		BinaryTree2DoubleLinkedList(node.left);
		if(tail == null) {
			head = node;
			tail = node;
		}else { //if tail is not null;
			tail.right = node;
			node.left = tail;
			tail = node;
		}
		BinaryTree2DoubleLinkedList(node.right);
		
	}

	/* Function to print nodes in a given doubly linked list */
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
	
	
}
