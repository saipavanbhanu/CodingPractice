package geeksforgeeks.binarytree.checking;

import geeksforgeeks.binarytree.Node;

public class SumTree {
    Node root;

    public int sum(Node root){
        if(root == null )
            return 0;
        return sum(root.left)+root.data+sum(root.right);
    }

    public boolean isSumTree(Node root){
        if(root == null){
            return true;
        }else if(root.left == null && root.right == null ){
            return true;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return isSumTree(root.left ) && ( leftSum + rightSum == root.data) && isSumTree(root.right);
    }

    public static void main(String [] args){
        SumTree tree = new SumTree();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);

        if (tree.isSumTree(tree.root))
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
    }
}
