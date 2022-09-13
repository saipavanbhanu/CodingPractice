package geeksforgeeks.stack;
import java.util.Stack;
public class SortAStackUsingRecursion {

    public static void sortedInsert(int x, Stack<Integer> s){
        if(s.size() > 0 ){
            int temp = s.pop();
            if(temp > x ){
                sortedInsert(x, s);
                s.push(temp);
            }else{
                s.push(temp);
                s.push(x);
            }
        }else{
            s.push(x);
        }
    }

    public static void sortStack(Stack<Integer> s){
        if(s.size() > 0){
            int temp = s.pop();
            sortStack(s);
            sortedInsert(temp, s);
        }
    }

    public static void main(String [] args){
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        //printStack(s);
        System.out.println(s);
        sortStack(s);

        System.out.println("Stack elements after sorting:");
        //printStack(s);
        System.out.println(s);
    }

}
