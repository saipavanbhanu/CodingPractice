package geeksforgeeks.arrays.optimization;

import java.util.Arrays;

public class LargestSumContiguousSubArray {

    public static int maxSubArraySum(int [] arr){
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        int start = 0, end = 0;
        for(int i = 1 ; i < arr.length; i++){
            maxEndingHere = maxEndingHere + arr[i];
            if(arr[i] > maxEndingHere ){
                maxEndingHere = arr[i];
                start=i;end=i;
            }
            if(maxEndingHere > maxSoFar){
                maxSoFar = maxEndingHere;
                end = i;
            }
        }
        System.out.println("start: "+start+" end: "+end);
        return maxSoFar;
    }

    public static void main(String [] args){
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(Arrays.toString(a));
        System.out.println("Maximum sub array sum :: "+maxSubArraySum(a));
    }

}
