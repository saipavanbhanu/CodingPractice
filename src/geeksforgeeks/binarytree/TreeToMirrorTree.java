package geeksforgeeks.binarytree;

public class TreeToMirrorTree {

	Node root;
	
	static class Node
	{
	    int data;
	    Node left, right;
	 
	    public Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}

	/* Helper function to test mirror(). Given a binary
    search tree, print out its data elements in
    increasing sorted order.*/
	void inOrder(Node node)
	{
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");

		inOrder(node.right);
	}

	Node mirror(Node node)
    {
        if (node == null)
            return node;
 
        /* do the subtrees */
        Node left = mirror(node.left);
        Node right = mirror(node.right);
 
        /* swap the left and right pointers */
        node.left = right;
        node.right = left;
 
        return node;
    }
	
	public static void main(String[] args) {
		/* creating a binary tree and entering the nodes */
		TreeToMirrorTree tree = new TreeToMirrorTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		/* print inorder traversal of the input tree */
		System.out.println("Inorder traversal of input tree is :");
		tree.inOrder(tree.root);
		System.out.println("");

		/* convert tree to its mirror */
		tree.mirror(tree.root);

		/* print inorder traversal of the minor tree */
		System.out.println("Inorder traversal of binary tree is : ");
		tree.inOrder(tree.root);
	}
}
