package geeksforgeeks.tree.binarysearchtree;

//https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/

import java.util.Stack;

public class Merge2BST{

	/* A utility function to print
	Inorder traversal of a Binary Tree */
	static void inorder(Node root){
		if (root != null){
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	// The function to print data of two BSTs in sorted order
	static void merge(Node root1, Node root2){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		Node current1 = root1;
		Node current2 = root2;
		//base conditions
		if(current1 == null) {
			//bst1 is null.
			inorder(root2);
			return;
		}
		if(current2 ==  null) {
			inorder(root1);
			return;
		}
		
		while( ( !s1.isEmpty() || current1 != null ) || ( !s2.isEmpty() || current2 != null ) ) {
			if(current1 != null || current2 != null) {
				if(current1 != null) {
					s1.push(current1);
					current1 = current1.left;
				}
				if(current2 != null) {
					s2.push(current2);
					current2 = current2.left;
				}
			}else { //if both of current1 and current2 are null
				//if either of the stack is empty then we can proceed with printing the other stack in inorder form.
				if(s1.isEmpty()) {
					while(!s2.isEmpty()) {
						Node top = s2.pop();
						top.left = null;
						inorder(top);
					}
				}
				if(s2.isEmpty()) {
					while(!s1.isEmpty()) {
						Node top = s1.pop();
						top.left = null;
						inorder(top);
					}
				}
				
				if(!s1.isEmpty() && !s2.isEmpty()) {
					Node top1 = s1.pop();
					Node top2 = s2.pop();
					
					if(top1.data < top2.data) {
						System.out.print(top1.data+" ");
						s2.push(top2);
						current2 = null;
						current1 = top1.right;
					}else {
						System.out.print(top2.data+" ");
						s1.push(top1);
						current1 = null;
						current2 = top2.right;
					}
				}
			}
			
			
			
		}
		
		
		
		
	}
	
	/* Driver code */
	public static void main(String[]args)
	{
		Node root1 = null, root2 = null;
	
		/* Let us create the following tree as first tree
				3
			/ \
			1 5
		*/
		root1 = new Node(3) ;
		root1.left = new Node(1);
		root1.right = new Node(5);
	
		/* Let us create the following tree as second tree
				4
			/ \
			2 6
		*/
		root2 = new Node(4) ;
		root2.left = new Node(2);
		root2.right = new Node(6);
	
		// Print sorted nodes of both trees
		merge(root1, root2);
	}
}

