package java8.streams;

import java.util.Arrays;
import java.util.List;

public class MatchUsage {
    public static void main(String [] args){
        // Creating a list of Integers
        List<Integer> list = Arrays.asList(3, 4, 6, 12, 20);

        // Stream anyMatch(Predicate predicate)
        boolean answer = list.stream().anyMatch(
                n -> {
                    System.out.println(n);
                    //return true;
                    return ((n * (n + 1)) / 4 == 5);
        }
                );

        // Displaying the result
        System.out.println(answer);
    }
}
