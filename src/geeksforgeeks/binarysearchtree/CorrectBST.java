package geeksforgeeks.binarysearchtree;

//https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/


public class CorrectBST {

	Node prev, first, middle, last;
	public CorrectBST() {
		// TODO Auto-generated constructor stub
		prev = first = middle = last = null;
	}
	
	// Driver program to test above functions
    public static void main (String[] args)
    {
        /*   6
            / \
           10  2
          / \ / \
         1  3 7 12
         
        10 and 2 are swapped
        */
 
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(20);
//        root.right.right = new Node(12);
//        root.right.left = new Node(7);
 
        System.out.println("Inorder Traversal"+
                        " of the original tree");
        CorrectBST tree = new CorrectBST();
        tree.printInorder(root);
 
        tree.correctBST(root);
 
        System.out.println("\nInorder Traversal"+
                          " of the fixed tree");
        tree.printInorder(root);
    }
    
    private void correctBST(Node root) {
		
    	correctBSTUtil(root);
    	
    	if(last == null) { //adjacent case
    		//swapping the node data of first and middle 
    		int temp = first.data;
    		first.data = middle.data;
    		middle.data = temp;
    	}else {//not adjacent case
    		//swapping the node data of first and last
    		int temp = first.data;
    		first.data = last.data;
    		last.data = temp;
    	}
    	
    	
    	
	}

    private void correctBSTUtil(Node root) {
		if(root == null) {
			return;
		}
		
		correctBSTUtil(root.left);
		if(prev != null && prev.data > root.data && first == null ) {
			first = prev;
			middle = root;
		}else if(prev != null && prev.data > root.data && last == null) {
			last = root;
		}
		
    	prev = root;
    	
    	correctBSTUtil(root.right);
    	
	}

/* A utility function to print
    Inorder traversal */
   void printInorder(Node node)
   {
       if (node == null)
           return;
       printInorder(node.left);
       System.out.print(" " + node.data);
       printInorder(node.right);
   }
	
}
