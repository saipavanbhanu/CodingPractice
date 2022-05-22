package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortedUsage {
    public static void main(String [] args){
        List<Integer> l = new ArrayList<>();
        l.add(0);l.add(25);l.add(10);l.add(15);l.add(5);l.add(20);
        System.out.println(l);

        List<Integer> sortedList = l.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        List<Integer> descList = l.stream().sorted((i1,i2) -> -i1.compareTo(i2)).collect(Collectors.toList());
        System.out.println(descList);
    }
}
