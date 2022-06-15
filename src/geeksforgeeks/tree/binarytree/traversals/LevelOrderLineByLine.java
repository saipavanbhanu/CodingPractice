package geeksforgeeks.tree.binarytree.traversals;

import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderLineByLine {

    public static void printLevelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nodeCount = 1;
        while(!queue.isEmpty()){
            while(nodeCount > 0){
                Node peek = queue.remove();
                System.out.print(peek.data+" ");
                if(peek.left != null){
                    queue.add(peek.left);
                }
                if(peek.right != null){
                    queue.add(peek.right);
                }
                nodeCount--;
            }
            System.out.println();
            nodeCount = queue.size();
        }
    }

    public static void main(String [] args){
        // Let us create binary tree shown in above diagram
       /*              1
                   /     \
                  2       3
                /   \       \
               4     5       6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        printLevelOrder(root);
    }
}

/*
*
* */
