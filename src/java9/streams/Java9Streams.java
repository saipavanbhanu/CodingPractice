package java9.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java9Streams {
    public static void main(String []args){
        List<Integer> list = List.of(1,2,3,4,5);
        List<Integer> li = list.stream().filter(x -> x % 2 == 0 ).collect(Collectors.toList());
        System.out.println(li);
        li = list.stream().map(x -> x * x ).collect(Collectors.toList());
        System.out.println(li);

        list = new ArrayList<>();
        for(int i = 0; i<10; i++)
            list.add(i);
        System.out.println("Flat map :: ");
        li = list.stream().flatMap(x -> {
                                            if(x%2 == 0 )
                                                return Stream.empty();
                                            else
                                                return Stream.ofNullable(x);
                                    }).collect(Collectors.toList());
        System.out.println(li);

        System.out.println("take while even no's :: ");
        list = List.of(2, 4, 1, 3, 6, 5, 8);
        li = list.stream().takeWhile( x -> x % 2 == 0 ).collect(Collectors.toList());
        System.out.println(li);

        System.out.println("drop while even no's :: ");
        li = list.stream().dropWhile( x -> x % 2 == 0 ).collect(Collectors.toList());
        System.out.println(li);

        System.out.println("Java 8 iterate method :: ");
        li = Stream.iterate(1, x -> x + 1 ).limit(5).collect(Collectors.toList());
        System.out.println(li);

        System.out.println("Java 9 iterate method :: ");
        li = Stream.iterate(1, x -> x <= 5, x -> x + 1 ).collect(Collectors.toList());
        System.out.println(li);




    }
}
