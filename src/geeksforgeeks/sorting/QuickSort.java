package geeksforgeeks.sorting;

import java.util.Arrays;

public class QuickSort {

    public static int partition(int [] arr, int left, int right ){
        int pivot = arr[right];
        int i = left, j=right-1;
        while(i < j){
            while(arr[i] < pivot ){
                i++;
            }
            while(arr[j] > pivot ){
                j--;
            }
            if(i < j ){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;j--;
            }
        }
        int temp = arr[right];
        arr[right] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void quicksort(int [] arr, int left, int right){
        if(left < right ){
            int partitionIndex = partition(arr, left, right);
            quicksort(arr, left, partitionIndex-1);
            quicksort(arr, partitionIndex+1, right);
        }
    }

    public static void main(String [] args){
        int arr[] = {10, 7, 8, 9, 1, 5};
        System.out.println(Arrays.toString(arr));
        quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
