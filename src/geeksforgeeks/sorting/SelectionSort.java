package geeksforgeeks.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            int smallestIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[smallestIndex]){
                    smallestIndex=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    public static void main(String args[]){
        int arr[] = {64,25,12,22,11};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
