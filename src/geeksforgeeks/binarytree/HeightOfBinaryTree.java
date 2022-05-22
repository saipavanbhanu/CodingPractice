package geeksforgeeks.binarytree;

public class HeightOfBinaryTree {
    Node root;

    public int height(Node root){
        if(root == null )
            return 0;

        int leftSubTreeHeight = height(root.left);
        int rightSubTreeHeight = height(root.right);
        if(leftSubTreeHeight > rightSubTreeHeight){
            return leftSubTreeHeight+1;
        }else
            return rightSubTreeHeight+1;
    }


    public static void main(String [] args){
        HeightOfBinaryTree tree = new HeightOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Height of tree :: "+tree.height(tree.root));

    }

}
