package geeksforgeeks.heap;

import java.util.Arrays;

public class MinHeap {

	final int MAX_SIZE; //max size of the heap
	int size; //current size of heap
	int arr[];
	
	MinHeap(int size){
		this.MAX_SIZE = size;
		this.arr = new int[size];
		this.size = 0;
	}
	int parent(int i) {
		return ( i - 1 )/2;
	}
	int leftChild(int i) {
		return 2 * i + 1;
	}
	int rightChild(int i) {
		return 2 * i + 2;
	}
	void swap(int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	private void insert(int data) {
		//System.out.println("Inserting data: "+data);
		if(size == MAX_SIZE) {
			System.out.println("Heap size is at max");
		}else {
			int index = size;
			arr[size++] = data;
			//heapify from bottom up approach
			while( parent(index) >= 0) {
				if( arr[parent(index)] > arr[index] ) {
					swap(index, parent(index));
					index = parent(index);
				}else {
					break;
				}
			}
		}
		//System.out.println("after insertion -min value:"+arr[0]);
	}
	
	
	public static void main(String[] arg){
 
        // Display message
        //System.out.println("The Min Heap is ");
 
        // Creating object opf class in main() methodn
        MinHeap minHeap = new MinHeap(15);
 
        // Inserting element to minHeap
        // using insert() method
 
        // Custom input entries
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
 
        // Print all elements of the heap
        minHeap.print();
 
        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                           + minHeap.arr[0]);
	
	}
	private void print() {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(arr));
	}


}
