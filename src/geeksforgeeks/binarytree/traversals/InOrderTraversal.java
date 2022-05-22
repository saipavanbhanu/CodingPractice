package geeksforgeeks.binarytree.traversals;

import java.util.Deque;
import java.util.LinkedList;

public class InOrderTraversal {
    Node root;
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    public void inorderRecursion(Node root){
        if(root == null )
            return;
        inorderRecursion(root.left);
        System.out.print(root.data+" ");
        inorderRecursion(root.right);
    }
    public void inorder(){
        Node current = root;
        Deque<Node> stack = new LinkedList();
        while(current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            Node temp = stack.pop();
            System.out.print(temp.data + " ");
            current = temp.right;
        }
    }
    /*
    *         1
    *      2    3
    *    4   5
    * */
    public static void main(String [] args ){
        /* creating a binary tree and entering
        the nodes */
        InOrderTraversal tree = new InOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("In-order with recursion");
        tree.inorderRecursion(tree.root);
        System.out.println("\nIn-order without recursion");
        tree.inorder();
    }
}
