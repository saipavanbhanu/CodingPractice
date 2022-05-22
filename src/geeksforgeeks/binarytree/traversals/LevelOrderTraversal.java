package geeksforgeeks.binarytree.traversals;

import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversal {
    Node root;

    public void levelOrder(){
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            Node poppedNode = queue.remove();
            System.out.print(poppedNode.data+" ");
            if(poppedNode.left != null )
                queue.add(poppedNode.left);
            if(poppedNode.right != null )
                queue.add(poppedNode.right);
        }
    }

    public static void main(String [] args){
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.levelOrder();
    }
}
