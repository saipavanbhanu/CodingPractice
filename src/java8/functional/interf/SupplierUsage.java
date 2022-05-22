package java8.functional.interf;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierUsage {
    public static void main(String [] args){
        Supplier<String> s = () -> {
            String otp = "";
            for(int i = 0; i<6; i++){
                otp = otp + (int ) (Math.random() * 10);
            }
            return otp;
        };
        System.out.println(s.get());


    }
}
