package geeksforgeeks.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int [] arr){
        //int arr[] = { 12, 11, 13, 5, 6 };
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int j = i;
            int temp = arr[i];
            while(j > 0 && arr[j-1] > temp ){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
    }

    public static void main(String [] args){
        int arr[] = { 12, 11, 13, 5, 6 };
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
