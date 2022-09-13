package geeksforgeeks.tree.binarytree;

public class Node{
    public int data;
    public Node left, right;
    public Node(int data){
        this.data = data;
        left = right = null;
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return Integer.toString(data);
    }
}
