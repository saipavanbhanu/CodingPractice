package geeksforgeeks.tree.binarysearchtree;

import java.util.Arrays;

public class KthSmallest {
	static int count = 0;
	public static Node insert(Node root, int x)	{
		if (root == null)
			return new Node(x);
		if (x < root.data)
			root.left = insert(root.left, x);
		else if (x > root.data)
			root.right = insert(root.right, x);
		return root;
	}
	
	public static void main(String[] args){
		Node root = null;
		int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
		for (int x : keys)
			root = insert(root, x);
		int k = 8;
		Arrays.sort(keys);
		System.out.println(Arrays.toString(keys));
		printKthSmallest(root, k);
	}

	private static void printKthSmallest(Node root, int k) {
		Node kthSmallest = kthSmallest(root, k);
		if(kthSmallest == null ) {
			System.out.println("value of "+k+" is out of bounds as compared to BST size");
		}else {
			System.out.println(k+"th smallest node: "+kthSmallest.data);
		}
	}

	private static Node kthSmallest(Node node, int k) {
		if(node == null) {
			return null;
		}
		Node kthSmallest = kthSmallest(node.left, k);
		if(kthSmallest != null) {
			return kthSmallest;
		}
		count++;
		if(count == k) {
			return node;
		}
		return kthSmallest(node.right, k);
	}
}
