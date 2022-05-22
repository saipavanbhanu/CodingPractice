package geeksforgeeks.sorting;

import java.util.Arrays;

public class HeapSort {
    //For ascending order we need to construct Max Heap
    public static void sort(int [] arr){
        int n = arr.length;
        int start = (n - 1)/2;
        while(start >= 0 ){
            heapify(arr, start, n );
            start--;
        }
        //System.out.println("After Build Heap :"+Arrays.toString(arr));
        for(int i = 0; i < n-1 ; i++){
            //System.out.println("max value :"+arr[0]);
            int temp = arr[n-i-1];
            arr[n-i-1] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, n-i-1);
        }
    }
    public static void heapify(int [] arr, int index, int size ){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
        if(left < size && arr[left] > arr[max]){
            max = left;
        }
        if(right < size && arr[right] > arr[max]){
            max = right;
        }
        if(max != index){
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp;
            heapify(arr, max, size);
        }
    }
    public static void main(String [] args){
        int arr[] = {12, 11, 13, 5, 6, 7};
        //int arr[] = { 4, 10, 3, 5, 1 };
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
