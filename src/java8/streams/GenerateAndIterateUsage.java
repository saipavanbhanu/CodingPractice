package java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateAndIterateUsage {
    public static void main(String []args){
        List<String> list = Stream.generate(() -> {
            String otp = "";
            for(int i = 0; i<6; i++){
                otp = otp + (int ) (Math.random() * 10);
            }
            return otp;
        })
                .limit(6)
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println("------------------------------------------------");
        List<Integer> integerList = Stream.iterate(0, i -> i+10 ).limit(6).collect(Collectors.toList());
        System.out.println(integerList);


    }
}
