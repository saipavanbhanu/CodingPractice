package java8.functional.interf;
import java.util.function.Function;

public class FunctionUsage {

    public static void main(String [] args ){
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("Bhanu"));
        System.out.println(f.apply("Pothuri"));

    }

}
