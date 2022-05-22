package geeksforgeeks.arrays.rearrangement;

import java.util.Arrays;

public class ReverseAnArray {

    public static void reverse(int arr[]){
        int left = 0, right = arr.length-1;
        while(left < right ){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String [] args){
        int arr[] = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}
