package geeksforgeeks.arrays.rearrangement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrangeGivenNosToBiggestNo {

    public static void printLargest(ArrayList<String> list ){
        Collections.sort(list, new Comparator<String>(){
            public int compare(String s1, String s2){
                return -s1.compareTo(s2);
            }
        });
        System.out.println(list);
    }

    public static void main(String args[]){
        ArrayList<String> arr;
        arr = new ArrayList<String>();

        //output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);

    }
}
