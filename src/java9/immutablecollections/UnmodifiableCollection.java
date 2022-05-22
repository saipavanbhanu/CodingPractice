package java9.immutablecollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableCollection {
    public static void main(String[] args){
        List<String> li = new ArrayList<>();
        li.add("Sunny");
        li.add("Bunny");
        li.add("Chinny");
        li = Collections.unmodifiableList(li);
        System.out.println("Immutable collection :: "+li);
        //li.add("Kanny");  //UnsupportedOperationException
        //li.remove("Sunny");   //UnsupportedOperationException
        //li.set(0,"Kanny");    //UnsupportedOperationException

        //Java 9 immutable "of" method
        List<String> beers = List.of("KF","KO","RC","FO");







    }
}
