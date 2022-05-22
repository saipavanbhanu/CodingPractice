package geeksforgeeks.arrays.rearrangement;

import java.util.Arrays;

public class MoveAllZerosToTheEnd {

    public static void rearrange(int arr[]){
        int i = 0;
        while(i<arr.length){
            if(arr[i] != 0)
                i++;
            else{
                int j = i+1;
                while(j<arr.length && arr[j]==0)
                    j++;
                if(j < arr.length ){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                i++;
            }
        }
    }
    public static void rearrangeOn(int arr[]){
        //Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        int i=0, j = i + 1;
        while(i<arr.length){
            if(arr[i] != 0){
                i++;
                j++;
            }else{
                while(j<arr.length && arr[j] == 0 )
                    j++;
                if(j<arr.length){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
                i++;
            }
        }
    }

    public static void main(String args[]){
        //Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println(Arrays.toString(arr));
        //rearrange(arr);
        rearrangeOn(arr);
        System.out.println(Arrays.toString(arr));

    }
}
