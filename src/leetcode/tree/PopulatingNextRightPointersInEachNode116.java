package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode116 {

	// Definition for a Node.
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

	class Solution {
	    public Node connect(Node root) {
	        if(root == null){
	            return root;
	        }
	        
	        Deque<Node> q = new LinkedList<>();
	        q.addLast(root);
	        
	        while(!q.isEmpty()){
	            int currSize = q.size();
	            while(currSize-1 > 0){
	                Node node = q.removeFirst();
	                if(node.left != null){
	                    q.addLast(node.left);
	                }
	                if(node.right != null){
	                    q.addLast(node.right);
	                }
	                node.next = q.getFirst();
	                currSize--;
	            }
	            Node node = q.remove();
	            node.next = null;
	            if(node.left != null){
	                q.addLast(node.left);
	            }
	            if(node.right != null){
	                q.addLast(node.right);
	            }
	        }
	        return root;
	    }
	}
}
