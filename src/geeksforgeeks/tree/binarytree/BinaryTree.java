package geeksforgeeks.tree.binarytree;
import java.util.Queue;
import java.util.LinkedList;
public class BinaryTree {
    static class Node{
        int data;
        Node left, right;
        Node(int key){
            data = key;
            left = right = null;
        }
    }
    public static Node root;
    public static void inorder(Node root){
        if(root == null )
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void insert(Node root, int key){
        Queue<Node> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.remove();
            if(temp.left == null){
                temp.left = new Node(key);
                break;
            }else{
                q.add(temp.left);
            }
            if(temp.right == null){
                temp.right = new Node(key);
                break;
            }else{
                q.add(temp.right);
            }
        }
    }
    public static void main(String [] args){
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print( "Inorder traversal before insertion:");
        inorder(root);

        int key = 12;
        insert(root, key);

        System.out.print("\nInorder traversal after insertion:");
        inorder(root);
    }
}
