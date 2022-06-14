package geeksforgeeks.binarysearchtree;

public class InOrderSuccessorWithParentPointer {
	static class Node {
	    int data;
	    Node left, right, parent;
	    Node(int d){
	        data = d;
	        left = right = parent = null;
	    }
	}
	static Node root;
	Node insert(Node node, int data){
        /* 1. If the tree is empty, return a new,    
         single node */
        if (node == null) {
            return (new Node(data));
        }
        else {
            Node temp = null;
            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            }
            else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }
            /* return the (unchanged) node pointer */
            return node;
        }
    }
	public static void main(String[] args){
		InOrderSuccessorWithParentPointer tree = new InOrderSuccessorWithParentPointer();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.inOrderSuccessor(temp);
        if (suc != null) {
            System.out.println(
                "Inorder successor of "
                + temp.data + " is " + suc.data);
        }
        else {
            System.out.println(
                "Inorder successor does not exist");
        }
    }
	private Node inOrderSuccessor(Node temp) {
		//temp - we need to find out the inorder successor for the temp node
		//left most child in the right subtree of "temp"
		if(temp.right != null) {
			Node succ = temp.right;
			while(succ.left != null) {
				succ = succ.left;
			}
			return succ;
		}else {
			//if right child is not there => then we need to go parent pointer.
			Node p = temp.parent;
			while(p != null && p.right == temp) {
				temp = p;
				p = p.parent;
				
			}
			return p;
		}
	}
	
	
}
