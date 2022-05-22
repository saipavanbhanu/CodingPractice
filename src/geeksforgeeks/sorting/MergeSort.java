package geeksforgeeks.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergesort(int [] arr, int left, int right){
        if(left < right ){
            int middle = ( left + right )/2;
            mergesort(arr, left, middle);
            mergesort(arr, middle+1, right);
            merge(arr, left, right);
        }
    }
    public static void merge(int [] arr, int left, int right ){
        //              0,  1,  2, 3, 4, 5
        //int arr[] = {12, 11, 13, 5, 6, 7};
        //System.out.println("left: "+left+" right: "+right);
        //System.out.println(Arrays.toString(arr));
        int middle = (left + right )/2;
        int[] temp = new int[right - left + 1];
        int tempCount = 0;
        int i = left, j = middle+1;
        while( i <= middle && j <= right ){
            if(arr[i] < arr[j]){
                temp[tempCount++]=arr[i];
                i++;
            }else{
                temp[tempCount++] = arr[j];
                j++;
            }
        }
        while( i <= middle ){
            temp[tempCount++] = arr[i];
            i++;
        }
        while( j <= right ){
            //System.out.println("tempcount: "+ tempCount+" j: "+j);
            temp[tempCount++] = arr[j];
            j++;
        }
        int count = 0;
        for(i = left; i <= right ; i++ ){
            arr[i] = temp[count++];
        }
    }
    public static void main(String [] args){
        int arr[] = {12, 11, 13, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        mergesort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
