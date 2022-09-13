package geeksforgeeks.tree.binarytree.lca;

import java.util.List;

import geeksforgeeks.tree.binarytree.Node;

import java.util.ArrayList;


public class LCAUsingPaths {
    Node root;
    List<Integer> path1 = new ArrayList<>();
    List<Integer> path2 = new ArrayList<>();

    public int findLCA(int n1, int n2){
        boolean firstNodeExists = findPath(path1, n1, root);
        boolean secondNodeExists = findPath(path2, n2, root);
        if( firstNodeExists && secondNodeExists ){
            int i = 0;
            while(i< path1.size() && i< path2.size() && path1.get(i).equals(path2.get(i))){
                i++;
            }
            return path1.get(i-1);
        }else{
            return -1;
        }
    }
    public boolean findPath(List<Integer> path, int n, Node node){
        if(node == null )
            return false;
        path.add(node.data);
        if(node.data == n ){
            return true;
        }
        if(node.left != null && findPath(path, n, node.left)){
            return true;
        }
        if(node.right != null && findPath(path, n, node.right)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static void main(String [] args ){
        LCAUsingPaths tree = new LCAUsingPaths();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        //System.out.println("LCA(4, 5): " + tree.findLCA(4,5));
        //System.out.println("LCA(4, 6): " + tree.findLCA(4,6));
        //System.out.println("LCA(3, 4): " + tree.findLCA(3,4));
        System.out.println("LCA(2, 4): " + tree.findLCA(2,4));
    }
}
