package geeksforgeeks.tree.binarytree;

import java.util.ArrayList;
import java.util.List;


public class ConnectNodesAtSameLevel {
	Node root;
	static class Node {
	    int data;
	    Node left, right, nextRight;
	    Node(int item){
	        data = item;
	        left = right = nextRight = null;
	    }
	    @Override
	    public String toString() {
	    	if(this == null) {
	    		return null;
	    	}else {
	    		return Integer.toString(this.data);
	    	}
	    }
	}
	
	// Driver program to test above functions
    public static void main(String args[])
    {
    	ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel();
 
        /* Constructed binary tree is
             10
            /  \
          8     2
         /
        3
        */
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
 
        // Populates nextRight pointer in all nodes
        tree.connect(tree.root);
 
        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in "
                           + "the tree"
                           + "(-1 is printed if there is no nextRight)");
        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.data + " is "
                           + a);
        int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.data + " is "
                           + b);
        int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.right.data + " is "
                           + c);
        int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.left.data + " is "
                           + d);
    }
    private int height(Node root) {
    	if(root == null)
    		return 0;
    	else {
    		return Math.max(height(root.left ), height(root.right)) + 1;
    	}
    }
	private void connect(Node root) {
		
		//list construction.
		int heightOfTree = height(root);
		final int MAX_NUMBER_OF_NODES = (int) (Math.pow((double)2, (double) heightOfTree) - 1);
		List<Node> list = new ArrayList<Node>(MAX_NUMBER_OF_NODES);
		if(root == null)
			return;
		
		list.add(root);
		list.add(null);
		int index = 0;
		
		while(true) {
			Node iter = list.get(index);
			if(iter == null) {
				if(index == list.size() - 1) {
					break;
				}else {
					list.add(null);
				}
			}else {
				if(iter.left != null) {
					list.add(iter.left);
				}
				if(iter.right != null) {
					list.add(iter.right);
				}
			}
			index++;
		}
		
		//setting the nextRight for every non null node in the list.
		for(int i = 0; i < list.size(); i++) {
			Node iter = list.get(i);
			if( iter != null) {
				iter.nextRight = list.get(i+1);
			}
		}
		
		//making the list available for garbage collection.
		list = null;
	}
    
    
}

