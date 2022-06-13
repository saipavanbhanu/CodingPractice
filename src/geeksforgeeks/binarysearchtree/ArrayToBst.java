package geeksforgeeks.binarysearchtree;

public class ArrayToBst {
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
		@Override
		public String toString() {
			return (data+" ");
		}
	}
	
	
	
	
	public static void main(String[] args) {
        ArrayToBst tree = new ArrayToBst();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        Node root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Inorder traversal of constructed BST");
        tree.inOrder(root);
        
        System.out.println("\nPreOrder traversal");
        tree.preOrder(root);
    }

	private void preOrder(Node root) {
		if(root == null)
			return;
		System.out.print(root);
		preOrder(root.left);
		preOrder(root.right);
	}

	private void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root);
		inOrder(root.right);
	}

	private Node sortedArrayToBST(int[] arr, int start, int end) {
		if(start < end) {
			int mid = (start + end )/2;
			Node root = new Node(arr[mid]);
			root.left = sortedArrayToBST(arr, start, mid-1);
			root.right = sortedArrayToBST(arr, mid+1, end);
			return root;
		}else if( start == end ) {
			return new Node(arr[start]);
		}else {
			return null;
		}
	}

}
