package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapUsage {
    public static void main(String [] args){
        List<Integer> l = new ArrayList<>();
        l.add(0);l.add(25);l.add(10);l.add(15);l.add(5);l.add(20);
        System.out.println(l);
        List<Integer> doubleList = l.stream().map( x -> 2*x ).collect(Collectors.toList());
        System.out.println(doubleList);
        l.stream().map( x -> 2*x ).forEach(System.out::println);

    }
}
