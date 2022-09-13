package geeksforgeeks.arrays.rearrangement;

import java.util.Arrays;

public class RearrangePositiveAndNegativeNos {

    public static void rearrange(int []arr){
      //int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        int pIndex=2, nIndex=1;
        for(int index = 0; index < arr.length; ){
            if( index % 2 == 0 ){
                //it should be -ve
                if(arr[index] < 0 )
                    index++;
                else{
                    nIndex=index+1;
                    while(nIndex < arr.length && arr[nIndex]>=0 ){
                        nIndex++;
                    }
                    if(nIndex != arr.length){
                        int temp = arr[index];
                        arr[index] = arr[nIndex];
                        arr[nIndex] = temp;
                    }
                    index++;
                    //nIndex++;
                    System.out.println("swp "+Arrays.toString(arr));
                }
            }else{
                //int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
                //it should be +ve
                if(arr[index] > 0 ){
                    index++;
                }else{
                    pIndex=index+1;
                    while(pIndex < arr.length && arr[pIndex]<0 ){
                        pIndex++;
                    }
                    if(pIndex != arr.length){
                        int temp = arr[index];
                        arr[index] = arr[pIndex];
                        arr[pIndex] = temp;
                    }
                    index++;
                    //pIndex++;
                    System.out.println("swp "+Arrays.toString(arr));
                }

            }
        }
    }

    public static void main(String [] args){
        int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        System.out.println("arr "+Arrays.toString(arr));
        rearrange(arr);
        System.out.println("fnl "+Arrays.toString(arr));
    }

}
