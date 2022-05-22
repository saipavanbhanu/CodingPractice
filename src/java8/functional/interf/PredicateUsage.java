package java8.functional.interf;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateUsage {
    public boolean m1(int i){
        return i%2 == 0 ;
    }
    public static boolean m2(int i){
        System.out.println("M2 method called..");
        return i%2 == 0 ;
    }

    public static void main(String [] args ){

        Predicate<Integer> p = i -> i%2==0;
        System.out.println(p.test(10));
        System.out.println(p.test(3));
        System.out.println("------------------------------------------------------------");
        IntPredicate ip = i -> i%2 == 0;
        System.out.println(ip.test(10));
        System.out.println(ip.test(3));
        System.out.println("------------------------------------------------------------");
        ip = PredicateUsage::m2;
        System.out.println(ip.test(10));
        System.out.println(ip.test(3));
        System.out.println("------------------------------------------------------------");
        PredicateUsage pu = new PredicateUsage();
        ip = pu::m1;
        System.out.println(ip.test(10));
        System.out.println(ip.test(3));


    }
}
