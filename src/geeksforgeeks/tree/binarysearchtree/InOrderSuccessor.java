package geeksforgeeks.tree.binarysearchtree;

import geeksforgeeks.tree.binarysearchtree.IsBST.Node;

/*In order successor without parent pointer*/

public class InOrderSuccessor {

	Node root;
	boolean dataExists;
	int count;

	public InOrderSuccessor() {
		root = null;
		dataExists = false;
		count = 0;
	}

	public static void main(String[] args) {
		InOrderSuccessor tree = new InOrderSuccessor();
		tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        
        int x = 5;
        Node succ = tree.inOrderSuccessor(tree.root, x);
        if (succ != null)
            System.out.printf(
                "Inorder Successor of %d is %d ",
                x, succ.data);
        else
            System.out.printf("\n Inorder Successor doesn't exit");
	
	}



	private Node inOrderSuccessor(Node node, int x) {
		if(node == null)
			return null;
		else {
			Node succ = null;
			succ = inOrderSuccessor(node.left, x);
			if(succ != null && dataExists ==  true) {
				return succ;
			}
			if(node.data == x) {
				dataExists = true;
				//System.out.println("node when data exists : "+node);
			}
			
			if(dataExists) {
				count++;
			}
			if(count == 2) {
				//System.out.println("node when count is 2: "+node);
				return node;
			}
				
			
			succ = inOrderSuccessor(node.right, x);
			if(succ != null && dataExists ==  true) {
				return succ;
			}
			return null;
		}
		
	}
	
}
