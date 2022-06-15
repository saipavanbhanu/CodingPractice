package geeksforgeeks.tree.binarysearchtree;

public class AVLTree {
	class Node{
		int key;
		int height;
		Node left, right;
		Node(int key){
			this.key = key;
			this.height = 1;
			this.left = this.right = null;
		}
	}
	Node root;
	
	int height(Node node) {
		if(node == null) {
			return 0;
		}else
			return node.height;
	}
	
	Node insert(Node rootNode, int key) {
		if(rootNode == null) {
			Node node = new Node(key);
			return node;
		}else {
			if(key < rootNode.key) {
				rootNode.left = insert(rootNode.left, key);
			}else if(key > rootNode.key) {
				rootNode.right = insert(rootNode.right, key);
			}else {
				//key == rootNode.key not handling the case.
				return rootNode;
			}
		}
		rootNode.height = 1 + Math.max(height(rootNode.left), height(rootNode.right));
		//need to update height of the current node.
		return rootNode;
	}
	
	int getBalancingFactor(Node node) {
		if(node == null)
			return 0;
		else 
			return height(node.left)-height(node.right);
	}
	
	void inorder(Node rootNode) {
		if(rootNode == null)
			return;
		inorder(rootNode.left);
		System.out.print(rootNode.key+" ");
		inorder(rootNode.right);
	}
	
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		 
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
 
        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("inorder traversal" +
                        " of constructed tree is : ");
        tree.inorder(tree.root);
	}

}
