package geeksforgeeks.binarytree.traversals;

import java.util.Deque;
import java.util.LinkedList;

public class SpiralLevelOrder {
    Node root;
    public void printSpiral(){
        if(root == null)
            return;
        Deque<Node> stack1 = new LinkedList<>();
        Deque<Node> stack2 = new LinkedList<>();
        stack1.push(root);
        boolean leftToRight = false;
        while(!stack1.isEmpty()){
            Node poppedNode = stack1.pop();
            System.out.print(poppedNode.data+" ");
            if(leftToRight){
                if(poppedNode.left != null)
                    stack2.push(poppedNode.left);
                if(poppedNode.right != null)
                    stack2.push(poppedNode.right);
            }else{//right to left
                if(poppedNode.right != null)
                    stack2.push(poppedNode.right);
                if(poppedNode.left != null)
                    stack2.push(poppedNode.left);
            }
            if(stack1.isEmpty()){
                Deque<Node> temp = stack1;
                stack1 = stack2;
                stack2 = temp;
                leftToRight = !leftToRight;
            }
        }
    }
    /*          1
              2   3
            7  6 5  4
    * */
    public static void main(String [] args ){
        SpiralLevelOrder tree = new SpiralLevelOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        System.out.println("Spiral Order traversal of Binary Tree is ");
        tree.printSpiral();
    }
}
