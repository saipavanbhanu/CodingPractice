package java8.interfaces;

interface Interf{
    default void m1(){
        System.out.println("Interface method called..");
    }
}
class Parent{
    public void m1(){
        System.out.println("Parent class method called..");
    }
}
public class DefaultUsage extends Parent implements Interf{
    /*public void m1(){
        System.out.println("Class method called..");
    }*/
    public static void main(String [] args ){
        DefaultUsage du = new DefaultUsage();
        du.m1();
        Interf interf = new DefaultUsage();
        interf.m1();
    }

}
