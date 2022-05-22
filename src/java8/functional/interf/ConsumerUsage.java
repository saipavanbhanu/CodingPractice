package java8.functional.interf;

import java.util.function.Consumer;

public class ConsumerUsage {
    public static void main(String [] args ){
        Consumer<String> c = s -> System.out.println(s);
        c.accept("Hello world");

    }
}
