package leetcode.tree.bt;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumWidthofBinaryTree662 {
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	 
	class Node {
	    int index;
	    TreeNode node;
	    Node(int index, TreeNode node){
	        this.index = index;
	        this.node = node;
	    }
	}
	class Solution {
	    int max = -1;
	    public int widthOfBinaryTree(TreeNode root) {
	        if(root == null){
	            return 0;
	        }
	        
	        Deque<Node> q = new ArrayDeque<>();
	        q.add(new Node(0, root));
	        
	        while(!q.isEmpty()){
	            int size = q.size();
	            Node start = null, end = null;
	            while(size > 0){
	                Node node = q.remove();
	                if(start == null){
	                    start = node;
	                }
	                end = node;
	                if(node.node.left != null){
	                    q.add(new Node(node.index*2+1, node.node.left));
	                }
	                if(node.node.right != null){
	                    q.add(new Node(node.index*2+2, node.node.right));
	                }
	                size--;
	            }
	            int currentWidth = -1;
	            if(start == end){
	                //only one node in the level
	                currentWidth = 1;
	            }else{
	                currentWidth = end.index - start.index + 1;
	            }
	            max = Math.max(max, currentWidth);            
	        }
	        return max;
	    }
	}
}
