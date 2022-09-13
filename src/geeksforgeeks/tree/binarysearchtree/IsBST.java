package geeksforgeeks.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class IsBST {
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return Integer.toString(data);
		}
	}
	Node root;
	Node prev;
	List<Node> inOrderList;
	public IsBST() {
		/*
		 * usually arraylist should be initialized with the maximum no of nodes based on the height of the tree.
		 * h = height of the tree
		 * Max no.of nodes = Math.pow(2, h)-1;
		 * */
		inOrderList = new ArrayList<IsBST.Node>();
		root = null;
		prev = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsBST tree = new IsBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
 
//        if (tree.isBST())
//            System.out.println("IS BST");
//        else
//            System.out.println("Not a BST");
        
        if (tree.isBSTWithoutExtraSpace())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
        
        
	}
	//using temp array.
	private boolean isBST() {
		isInOrderBST(root);
		//iterate over the inorderList.
		//System.out.println(inOrderList);
		for(int i = 0; i < inOrderList.size() - 1; i++) {
			if(inOrderList.get(i).data < inOrderList.get(i + 1).data) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	private boolean isBSTWithoutExtraSpace() {
		return isInOrderBstWithoutExtraSpace(root);
	}
	
	
	private void isInOrderBST(Node node){
		if(node == null) {
			return;
		}else {
			isInOrderBST(node.left);
			inOrderList.add(node);
			isInOrderBST(node.right);
		}
	}
	
	private boolean isInOrderBstWithoutExtraSpace(Node node) {
		if(node == null) {
			return true;
		}else {
			boolean leftBst = isInOrderBstWithoutExtraSpace(node.left);
			boolean nodeBst = false;
			if(prev != null && prev.data < node.data) {
				nodeBst = true;
			}else if(prev == null ) {
				nodeBst = true;
			}
			prev = node;
			
			boolean rightBst = isInOrderBstWithoutExtraSpace(node.right);
			
			return leftBst && nodeBst && rightBst;
		}
		
	}

}
