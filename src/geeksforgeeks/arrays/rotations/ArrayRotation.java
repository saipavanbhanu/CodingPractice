package geeksforgeeks.arrays.rotations;

import java.util.Arrays;

public class ArrayRotation {

    /*
    * Time Complexity O(n*d)
    * */
    public static void rotate(int arr[], int d){
        int i;
        for(i = 1; i <= d; i++){
            int temp = arr[0];
            int j;
            for(j = 0; j < arr.length - 1; j++){
                arr[j] = arr[j+1];
            }
            arr[j]=temp;
        }
    }

    // Time Complexity O(n)
    public static void rotation(int arr[], int d){
        d = d % arr.length;
        //{ 1, 2, 3, 4, 5, 6, 7} n=7, d=2
        //int tempArr[] = {0,1,2,3,4,5,6, 7, 8, 9, 10, 11};
        int i, j, temp;
        for(i = 0; i < d; i++){
            j=i;
            temp = arr[i];
            while(j + d < arr.length ){
                arr[j] = arr[j+d];
                j=j+d;
            }
            arr[j]=temp;
            //System.out.println("tmp "+Arrays.toString(tempArr));
            //System.out.println("arr "+Arrays.toString(arr));
        }
    }
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else
            return gcd(b, a%b);
    }

    public static void jugglingAlgorithm(int arr[], int d){
        int gcd = gcd(arr.length, d);
        int i, j, k, n = arr.length, temp;
        for(i = 0; i < gcd; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
                System.out.println("tmp "+Arrays.toString(arr));
            }
            arr[j] = temp;
        }
    }
    public static void main(String [] args){
        //int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        /*System.out.println(Arrays.toString(arr));
        rotate(arr,2);
        System.out.println(Arrays.toString(arr));*/
        /*System.out.println("My approach");
        System.out.println("arr "+Arrays.toString(arr));
        rotation(arr,3);
        System.out.println("arr "+Arrays.toString(arr));*/
        System.out.println("Juggling Algorithm");
        System.out.println("arr "+Arrays.toString(arr));
        jugglingAlgorithm(arr,2);
        System.out.println("arr "+Arrays.toString(arr));

    }


}
