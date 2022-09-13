package geeksforgeeks.tree.binarytree;

public class FoldableBinaryTree {
    Node root;
    public boolean isFoldable(Node root){
        if(root == null){
            return true;
        }else{
            mirror(root.left);
            boolean result = isStructureSame(root.left, root.right);
            mirror(root.left);
            return result;
        }
    }
    public boolean isStructureSame(Node first, Node second ){
        if(first == null && second == null ){
            return true;
        }
        if( ( first != null && second != null ) && isStructureSame(first.left, second.left)
                                                && isStructureSame(first.right, second.right)){
            return true;
        }
        return false;
    }
    public void mirror(Node root){
        if(root == null)
            return;

        mirror(root.left);
        mirror(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public static void main(String [] args){
        FoldableBinaryTree tree = new FoldableBinaryTree();
        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.left.right = new Node(5);

        if (tree.isFoldable(tree.root))
            System.out.println("Tree is foldable");
        else
            System.out.println("Tree is not foldable");

    }

}
