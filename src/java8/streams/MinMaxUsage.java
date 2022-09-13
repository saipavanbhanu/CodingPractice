package java8.streams;

import java.util.ArrayList;
import java.util.List;

public class MinMaxUsage {
    public static void main(String [] args){
        List<Integer> l = new ArrayList<>();
        l.add(0);l.add(25);l.add(10);l.add(15);l.add(5);l.add(20);
        System.out.println(l);

        Integer min = l.stream().min((i1,i2)-> i1.compareTo(i2)).get();
        Integer max = l.stream().max((i1,i2)-> i1.compareTo(i2)).get();
        System.out.println("Min :: "+min+"----Max :: "+max);
    }
}
