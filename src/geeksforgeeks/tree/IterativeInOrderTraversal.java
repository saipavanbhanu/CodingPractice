package geeksforgeeks.tree;

import java.util.Stack;

public class IterativeInOrderTraversal {
	Node root;
	static class Node{
		int data;
		Node left, right;
		Node(int d){
			this.data = d;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return Integer.toString(data);
		}
	}
	public void inorder() {
		//iterative traversal using stack;
		Stack<Node> stack = new Stack<Node>();
		Node temp = root;
		do {
			while(temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			Node top = stack.pop();
			System.out.print(top.data+" ");
			temp = top.right;
		
			if(stack.isEmpty() && temp == null)
				break;
		} while (true);

	}
	public static void main(String args[]){
 
        /* creating a binary tree and entering
        the nodes */
		IterativeInOrderTraversal tree = new IterativeInOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }
	
}
