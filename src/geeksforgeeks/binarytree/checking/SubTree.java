package geeksforgeeks.binarytree.checking;

import geeksforgeeks.binarytree.Node;

public class SubTree {
    Node root1, root2;
    public boolean isEquivalent(Node t, Node s){
        if(t == null && s == null ){
            return true;
        }else if(t == null || s == null ){
            return false;
        }else{
            return ( t.data == s.data ) && isEquivalent(t.left, s.left) && isEquivalent(t.right, s.right);
        }
    }
    public boolean isSubtree(Node t, Node s){
        if(s == null )
            return true;
        if(t == null )
            return false;
        boolean result = isEquivalent(t,s);
        if(result)
            return result;
        else{
            return isSubtree(t.left, s) || isSubtree(t.right, s);
        }
    }

    public static void main(String [] args){
        SubTree tree = new SubTree();
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        tree.root1 = new Node(26);
        tree.root1.right = new Node(3);
        tree.root1.right.right = new Node(3);
        tree.root1.left = new Node(10);
        tree.root1.left.left = new Node(4);
        tree.root1.left.left.right = new Node(30);
        tree.root1.left.right = new Node(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        tree.root2 = new Node(10);
        tree.root2.right = new Node(6);
        tree.root2.left = new Node(4);
        tree.root2.left.right = new Node(30);

        if (tree.isSubtree(tree.root1, tree.root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
    }
}
