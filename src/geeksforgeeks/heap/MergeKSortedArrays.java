package geeksforgeeks.heap;

import java.util.Arrays;

public class MergeKSortedArrays {
	static class HeapNode{
		int data;
		int index; //index of the row where it is read from. //rowIndex
		HeapNode(int data, int index){
			this.data = data;
			this.index = index;
		}
	}
	
	static class MinHeap {

		private final int MAX_SIZE; //max size of the heap
		private int size; //current size of heap
		private HeapNode arr[];
		
		MinHeap(int size){
			this.MAX_SIZE = size;
			this.arr = new HeapNode[size];
			this.size = 0;
		}
		private int parent(int i) {
			return ( i - 1 )/2;
		}
		private int leftChild(int i) {
			return 2 * i + 1;
		}
		private int rightChild(int i) {
			return 2 * i + 2;
		}
		private void swap(int index1, int index2) {
			HeapNode temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
		}
		public void insert(HeapNode data) {
			//System.out.println("Inserting data: "+data);
			if(size == MAX_SIZE) {
				System.out.println("Heap size is at max");
			}else {
				int index = size;
				arr[size++] = data;
				//heapify from bottom up approach
				while( parent(index) >= 0) {
					if( arr[parent(index)].data > arr[index].data ) {
						swap(index, parent(index));
						index = parent(index);
					}else {
						break;
					}
				}
			}
		}
		private void heapify(int index) {
			//heapify from top to bottom;
			
			while(index < size) {
				int leftIndex = leftChild(index);
				int rightIndex = rightChild(index);
				int minIndex = index;
				if( leftIndex < size && arr[minIndex].data > arr[leftIndex].data) {
					minIndex = leftIndex;
				}
				if( rightIndex < size && arr[minIndex].data > arr[rightIndex].data) {
					minIndex = rightIndex;
				}
				
				if(minIndex != index) {
					swap(index, minIndex);
					//heapify
					index = minIndex;
				}else {
					break;
				}
			}
		}
		public HeapNode extractMin() {
			if(size == 0) {
				System.out.println("Heap is already empty");
				return null;
			}else {
				HeapNode min = arr[0];
				arr[0] = arr[size-1];
				size--;
				heapify(0);
				//System.out.println("extractMin: "+min.data);
				return min;
			}
		}
		public boolean isEmpty() {
			if(size == 0) {
				return true;
			}else
				return false;
			
		}
	}
	
	public static void main(String[] args)
    {
        int[][] arr = { { 2, 6, 12, 34 },
                        { 1, 9, 20, 1000 },
                        { 23, 34, 90, 2000 } };
        final int COLUMNS = 4;
        final int ROWS = 3;
        int[] output = new int[ROWS * COLUMNS];
        mergeKArrays(arr, ROWS, output);
        System.out.println("Merged array is ");
        printArray(output, ROWS * COLUMNS);
    }
	private static void mergeKArrays(int[][] arr, final int ROWS, int[] output) {
		if(ROWS == 1) {
			output = arr[0];
		}else {
			int colIndexOfEachRow[] = new int[arr[0].length];
			MinHeap minHeap = new MinHeap(ROWS);
			//initialize minheap with all the 0th index elements of the rows.
			for(int i = 0; i < ROWS; i++) {
				minHeap.insert(new HeapNode(arr[i][0], i));
			}
			int outputIndex = 0;
			while(!minHeap.isEmpty()) {
				HeapNode min = minHeap.extractMin();
				output[outputIndex++] = min.data;
				int extractedRowIndex = min.index;
				colIndexOfEachRow[extractedRowIndex]++;
				if(colIndexOfEachRow[extractedRowIndex] < arr[0].length) {
					minHeap.insert(new HeapNode(arr[min.index][colIndexOfEachRow[extractedRowIndex]], extractedRowIndex ));
					//System.out.println("insert "+arr[min.index][colIndexOfEachRow[extractedRowIndex]]+" into heap");
				}
			}
		}
	}

	private static void printArray(int[] output, int size) {
		System.out.println(Arrays.toString(output));
	}
}
