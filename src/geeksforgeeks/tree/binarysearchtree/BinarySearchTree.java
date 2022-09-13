package geeksforgeeks.tree.binarysearchtree;

public class BinarySearchTree {
    class Node{
        int key;
        Node left, right;
        Node(int key){
            this.key = key;
            left = right = null;
        }
    }
    Node root;
    public void insert(int key){
        root = insertRec(root, key);
    }
    public Node insertRec(Node node, int key){
        if(node == null){
            Node newNode = new Node(key);
            return newNode;
        }
        if(key < node.key ){
            node.left = insertRec(node.left, key);
        }else
            node.right = insertRec(node.right, key);
        return node;
    }
    public void inorder(){
        inorderRec(root);
    }
    public void inorderRec(Node node){
        if(node != null){
            inorderRec(node.left);
            System.out.print(node.key+" ");
            inorderRec(node.right);
        }
    }
    public void deleteKey(int key){
        root = deleteRec(root, key);
    }
    public Node deleteRec(Node node, int key){
        if(node == null ){
            return node;
        }
        if(key < node.key){
            node.left = deleteRec(node.left, key);
        }else if(key > node.key){
            node.right = deleteRec(node.right, key);
        }else{
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;

            node.key = inorderSuccessor(node.right);
            //System.out.println("Inorder successor:: "+node.key);
            node.right = deleteRec(node.right, node.key);
        }
        return node;
    }
    public int inorderSuccessor(Node node){
        int minValue = node.key;
        while(node != null){
            minValue = node.key;
            node = node.left;
        }
        return minValue;
    }
    public static void main(String args[]){
        BinarySearchTree tree = new BinarySearchTree();
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        // print inorder traversal of the BST
        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }

}
