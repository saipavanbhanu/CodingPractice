package utilities.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable<Student>{
    int rollno;
    String name, address;
    // Constructor
    public Student(int rollno, String name,
                   String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
    // Used to print student details in main()
    public String toString() {
        return this.rollno + " " + this.name +
                " " + this.address;
    }
	@Override
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		return name.compareTo(s.name);
	}
	
}
class SortByRoll implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        //ascending order of roll no's
        return s1.rollno - s2.rollno;
    }
}
public class CollectionsSortUsage {
    public static void main(String args[]){
        ArrayList<String> al = new ArrayList<String>();
        al.add("Geeks For Geeks");
        al.add("Friends");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");
        System.out.println("Unsorted List :: "+al);
        Collections.sort(al);
        System.out.println("Sorted list :: "+al);
        Collections.sort(al, Collections.reverseOrder());
        System.out.println("Reverse order list :: "+al);

        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));
        System.out.println(ar);
        Collections.sort(ar,new SortByRoll());
        System.out.println("Sort by rollno: "+ar);
        Collections.sort(ar);
        System.out.println("Sort by name: "+ar);
        
    }
}
