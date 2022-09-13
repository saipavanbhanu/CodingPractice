package utilities.lang;

public class IntegerUsage {
    public static void main(String [] args){
        Integer i = new Integer(20);
        System.out.println(i);
        i = new Integer("21");
        System.out.println(i);
        System.out.println(Integer.parseInt("22"));
        System.out.println(Integer.valueOf("23"));
    }
}
