package geeksforgeeks.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int [] arr){
        for(int i = 0; i < arr.length-1 ; i++ ){
            boolean swapped = false;
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false)
                break;
        }
    }

    public static void main(String [] args){
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
