package geeksforgeeks.binarysearchtree;

public class Node {
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
		left = right = null;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data+" ";
	}
}
