package java9.module;

import java.util.stream.Stream;

public class GetModuleName {
    public static void main(String []args ){

        Class c = Stream.class;
        System.out.println("Module of Stream.class :: "+c.getModule());
        System.out.println("Module of String.class :: "+String.class.getModule());


    }
}
