package java8.lambdas;
interface Interf{
    public int square(int x);
}
class Test implements Interf{
    @Override
    public int square(int x) {
        System.out.println("Square of "+x + " is "+x*x);
        return x*x;
    }
}
public class SquareANumber {
    public static void main(String [] args){
        Interf interf = new Test();
        interf.square(3);
        Interf interf1 = x -> {
            System.out.println("Square of "+x+" is "+x*x);
            return x*x;
        };
        interf1.square(4);
    }
}