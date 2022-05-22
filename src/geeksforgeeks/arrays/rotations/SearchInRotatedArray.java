package geeksforgeeks.arrays.rotations;

import java.util.Arrays;

public class SearchInRotatedArray {

    public static int search(int arr[], int key, int left, int right){
        //int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        //int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int mid = ( left + right )/2;
        boolean found = false;
        while( left <=right ){
            if(left == right ){
                if(arr[mid] == key){
                    return mid;
                }else
                    return -1;
            }
            if(arr[mid] == key){
                //found = true;
                return mid;
            }else if(arr[left] < arr[mid]){
                if(arr[left] <= key && key <= arr[mid] )
                    return binarySearch(arr, key, left, mid-1);
                else
                    return search(arr, key, mid+1, right);
            }else if(arr[mid] < arr[right]) {
                if (arr[mid] <= key && key <= arr[right])
                    return binarySearch(arr, key, mid + 1, right);
                else
                    return search(arr, key, left, mid - 1);
            }
        }
        return -1;
    }
    public static int binarySearch(int arr[], int key, int left, int right){
        int  mid = ( left + right ) / 2;
        while(left <= right ) {
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
            mid = ( left + right ) / 2;
        }
        return -1;
    }
    public static void main(String [] args) {
      //int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int key = -10;
        //System.out.println("Found :: "+binarySearch(arr, key, 0, arr.length-1));
        System.out.println("arr "+ Arrays.toString(arr));
        System.out.println("key "+key);
        System.out.println("Index :: "+search(arr, key, 0, arr.length-1));
    }
}
