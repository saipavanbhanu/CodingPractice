package multithreading.problems;


import java.util.Arrays;
import java.util.Random;

public class MultiThreadedMergeSort {
    private static final int size = 25;
    private static Random random = new Random();
    private static int[] input = new int[size];
    public static void main(String[] args) {
        for(int i = 0; i < size; i++){
            input[i] = random.nextInt(0, 100);
        }
        System.out.println(Arrays.toString(input));
        mergesort(0, size-1);
        System.out.println(Arrays.toString(input));
    }
    private static void mergesort(int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        mergesort(start, mid);
        mergesort(mid+1, end);
        //System.out.println("start: "+start+"mid: "+mid+"end: "+end);
        int []tempArr = new int[size];
        int arrIndex = start;
        int i = start;
        int j = mid+1;
        int k = start;
        while(k <= end){
            if(i<=mid && j <= end){
                tempArr[arrIndex] = Math.min(input[i], input[j]);
                if(tempArr[arrIndex] == input[i]){
                    i++;
                }else{
                    j++;
                }
            }else if(i > mid && j <= end){
                tempArr[arrIndex] = input[j];
                j++;
            }else{
                tempArr[arrIndex] = input[i];
                i++;
            }
            arrIndex++;
            k++;
        }
        for(i = start; i <= end; i++){
            input[i] = tempArr[i];
        }
    }
}
