package java9.diamondoperator;

import java.util.Iterator;

public class IteratorExample {
    public static void main(String [] args){
        String [] array = new String[]{ "Bhanu", "Sai", "Pavan", "Kumar", "Pothuri"};
        Iterator<String> iterator = new Iterator<>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < array.length;
            }
            @Override
            public String next() {
                return array[i++];
            }
        };
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
