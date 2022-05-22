package java8.streams;

import java.util.ArrayList;
import java.util.List;

public class CountUsage {
    public static void main(String []args){
        List<Integer> l = new ArrayList<>();
        l.add(0);l.add(25);l.add(10);l.add(15);l.add(5);l.add(20);
        System.out.println(l);

        long count = l.stream().count();
        System.out.println("Count :: "+count);
    }
}
