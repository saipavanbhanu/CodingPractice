package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalUsage {
    public static void main(String [] args){
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());

        List<String> listOfStrings = Arrays.asList("Mark", "Howard", "Anthony D'Cornian");
        Optional<String> largeString
                = listOfStrings.stream().filter(str -> str.length() > 10).findAny();
        largeString.ifPresent(System.out::println);
        if(largeString.isPresent())
            System.out.println("Using get() - "+largeString.get());

        System.out.println("OrElse :: "+empty.orElse("Default String"));
        System.out.println("OrElse :: "+largeString.orElse("Default String "));
        Optional<String> str = Optional.ofNullable(null);
        str.ifPresent(System.out::println);

        Optional<Integer> intOptional = Optional.of(34);
        Optional<Integer> evenIntOptional = intOptional.filter(i -> i % 2 == 0);
        System.out.println(evenIntOptional.orElse(0));

        Optional<Integer> oddIntOptional = intOptional.filter(i -> i % 2 != 0);
        System.out.println(oddIntOptional.orElse(0));


    }
}
