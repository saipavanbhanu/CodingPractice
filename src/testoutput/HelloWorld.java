package testoutput;

import java.io.FileReader;

interface Interf{
    public void m1();
}
class Test implements Interf{
    @Override
    public void m1() {
        System.out.println("Without lambda expression : Inside the method 1");
    }
}
public class HelloWorld {
    public static void main(String[] args){
        Interf interf = new Test();
        interf.m1();
        System.out.println("Hello world!!");
        Interf interf1 = () -> System.out.println("With Lambda expression: Inside the method 1");
        interf1.m1();

    }
}
