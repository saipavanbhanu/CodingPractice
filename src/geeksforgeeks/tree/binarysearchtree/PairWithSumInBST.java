package geeksforgeeks.tree.binarysearchtree;

import java.util.Stack;

public class PairWithSumInBST {

	// Driver program to test above functions
	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);

		int target = 21;
		if (isPairPresent(root, target) == false)
			System.out.print("\nPair doesn't exists\n");
		else
			System.out.println("Pair exists");
	}

	private static boolean isPairPresent(Node root, int target) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		boolean done1 = false, done2 = false;
		Node curr1 = root, curr2 = root;
		int val1 = 0, val2 = 0;
		while (true) {

			// iterative inorder traversal
			while (done1 == false) {
				if (curr1 != null) {
					s1.push(curr1);
					curr1 = curr1.left;
				} else { // curr1 is null
					if (!s1.isEmpty()) {
						curr1 = s1.pop();
						val1 = curr1.data;
						curr1 = curr1.right;
						done1 = true;
					} else {// if stack is empty

					}

				}
			}

			// iterative reverse inorder traversal
			while (done2 == false) {
				if (curr2 != null) {
					s2.push(curr2);
					curr2 = curr2.right;
				} else { // curr1 is null
					if (!s2.isEmpty()) {
						curr2 = s2.pop();
						val2 = curr2.data;
						curr2 = curr2.left;
						done2 = true;
					} else {// if stack is empty
					}
				}
			}

			if(val1 + val2 == target) {
				return true;
			}else if(val1 + val2 < target) {
				done1 = false;
			}else { //val1 + val2 > target
				done2 = false;
			}
			
			if(val1 >= val2) {
				return false;
			}
			
		}

	}
}
