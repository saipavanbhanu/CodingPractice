package java9.interfaces;
interface PriorToJava8{
    public abstract void m1();
    public abstract void m2();
    //public abstract void m3();
    default void m4(){
        //System.out.println("Implementation of m4");
        m7("4");
    }
    default void m6(){
        //System.out.println("Implementation of m6");
        m7("6");
    }
    private void m7(String s){
        System.out.println("Implementation of m"+s);
    }
    public static void m5(){
        m8();
    }
    private static void m8(){
        System.out.println("Implementation of m5");
    }
}
class Test implements PriorToJava8{
    public void m1(){
        System.out.println("Implementation of m1");
    }
    public void m2(){
        System.out.println("Implementation of m2");
    }
}
public class PrivateMethods {
    public static void main(String [] args ){
        Test t = new Test();
        t.m1();
        t.m2();
        t.m4();
        t.m6();
        PriorToJava8.m5();
    }
}
