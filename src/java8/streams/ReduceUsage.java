package java8.streams;

import java.util.ArrayList;
import java.util.List;

public class ReduceUsage {
    public static void main(String [] args ) {
        List<Integer> li = new ArrayList<Integer>();
        for(int i=1;i<8;i++){
            li.add(i);
        }

        int sum = li.stream().reduce((i1, i2)->i1+i2).get();
        System.out.println("Sum :: "+sum);
        int product = li.stream().reduce(1,(i1, i2) -> i1*i2);
        System.out.println("Product :: "+product);

    }
}
