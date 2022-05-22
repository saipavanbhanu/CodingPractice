package java8.streams;
import java.util.stream.Stream;
public class StreamOfUsage {
    public static void main(String [] args ){
        Stream<Integer> s = Stream.of(9,99,999,9999,99999);
        s.forEach(System.out::println);

        Double d[] = {10.0,10.1,10.2,10.3,10.4,10.5};
        Stream sd = Stream.of(d);
        sd.forEach(System.out::println);
    }
}
