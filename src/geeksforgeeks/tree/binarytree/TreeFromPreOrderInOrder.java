package geeksforgeeks.tree.binarytree;

//https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
/*
 * instead of linear search we can use map to find out the search in O(N) time complexity
 * otherwise time complexity is O(N^2) */

public class TreeFromPreOrderInOrder {
	int preIndex = 0;
	
	static class TreeNode{
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public static void main(String[] args) {
		
		
		TreeFromPreOrderInOrder tree = new TreeFromPreOrderInOrder();
		 
		/*
		 * int in[] = new int[] { 0, 1, 2, 3, 4, 5, 6 }; int pre[] = new int[] { 3, 1,
		 * 0, 2, 5, 4, 6 };
		 */
        
        int in[] = new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
        int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };
        
        int len = in.length;
 
        TreeNode root = tree.buildTree(pre, in, 0, len-1);
 
        tree.printInorder(root);

	}

	private int search(int data, int[] in, int inStart, int inEnd) {
		for(int i = inStart; i <= inEnd; i++) {
			if(in[i] == data)
				return i;
		}
		return -1;
	}
	
	private TreeNode buildTree(int[] pre, int[] in, int inStart, int inEnd) {
		if(preIndex < pre.length) {
			if(inStart > inEnd)
				return null;
			TreeNode node = new TreeNode(pre[preIndex++]);
		
			int searchIndex = search(node.data, in, inStart, inEnd);
			
			node.left 	= buildTree(pre, in, inStart, searchIndex-1);
			node.right	= buildTree(pre, in, searchIndex + 1, inEnd);
			
			return node;
		}else {
			return null;
		}
	}

	private void printInorder(TreeNode root) {
		if(root == null)
			return;
		printInorder(root.left);
		System.out.print(root.data+" ");
		printInorder(root.right);
	}
	
}
