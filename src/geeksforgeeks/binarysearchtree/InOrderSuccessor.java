package geeksforgeeks.binarysearchtree;

import geeksforgeeks.binarysearchtree.IsBST.Node;

public class InOrderSuccessor {

	Node root;
	boolean dataExists;
	int count;
	Node successor;
	
	public InOrderSuccessor() {
		root = null;
		dataExists = false;
		count = 1;
		successor = null;
	}

	public static void main(String[] args) {
		InOrderSuccessor tree = new InOrderSuccessor();
		tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        
        int x = 4;
        tree.inOrderSuccessor(tree.root, x);
        if (tree.successor != null)
            System.out.printf(
                "\n Inorder Successor of %d is %d ",
                x, tree.successor.data);
        else
            System.out.printf("\n Inorder Successor doesn't exit");
	
	}



	private void inOrderSuccessor(Node node, int x) {
		if(node != null && count == 1) {
			
			inOrderSuccessor(node.left, x);
			if(dataExists == true && count == 1) {
				count--;
				successor = node;
				return ;
			}
			if(node.data == x) {
				dataExists = true;
			}
			inOrderSuccessor(node.right, x);
			
		}
	}
	
}
