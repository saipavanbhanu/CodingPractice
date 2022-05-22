package geeksforgeeks.mustDoInterviewPreparation;

import java.util.Scanner;

public class MissingNumberInArray {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            long calculatedTotal = 0;
            for(int i = 0; i<n-1;i++){
                int element = sc.nextInt();
                calculatedTotal += element;
            }
            long actualTotal = n * (n+1)/2;
            System.out.println(actualTotal-calculatedTotal);
            t--;
        }
    }
}