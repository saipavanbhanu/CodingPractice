package geeksforgeeks.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LCA {
	Node root;
	List<Node> path1;
	List<Node> path2;
	
	LCA(){
		path1 = new ArrayList<>();
		path2 = new ArrayList<>();
	}
	public static void main(String[] args){
		LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
 
        System.out.println("LCA(4, 5): " + tree.findLCA(4,5));
        System.out.println("LCA(4, 6): " + tree.findLCA(4,6));
        System.out.println("LCA(3, 4): " + tree.findLCA(3,4));
        System.out.println("LCA(2, 4): " + tree.findLCA(2,4));
    }
	
	private boolean findPath(Node node, int n, List<Node> path) {
		if(node == null) {
			return false;
		}
		path.add(node);
		if(node.data == n) {
			return true;
		}else {
			if(findPath(node.left, n, path)) {
				return true;
			}
			if(findPath(node.right, n, path)) {
				return true;
			}
			
			//n doesn't exist on both node.left / node.right
			path.remove(path.size() - 1);
			return false;
		}
	}
	
	private int findLCA(int n1, int n2) {
		path1.clear();
		path2.clear();
		
		boolean flag1 = findPath(root, n1, path1);
		boolean flag2 = findPath(root, n2, path2);
		System.out.println("Path1 : "+path1+" Path2: "+path2);
		if(flag1 && flag2) {
			//similar to y-section of a linked list
			int i = 0;
			Node lca = null;
			while(i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
				lca = path1.get(i);
				i++;
			}
			return lca.data;
		}else {
			return -1;
		}
	}
}
