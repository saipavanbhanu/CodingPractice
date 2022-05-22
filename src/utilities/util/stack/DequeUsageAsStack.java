package utilities.util.stack;
import java.util.Deque;
import java.util.LinkedList;

public class DequeUsageAsStack {
    public static void main(String [] args){
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 5; i > 0 ; i--){
            deque.push(i);
        }
        System.out.println(deque);
        deque.pop();
        System.out.println(deque);
        System.out.println(deque.peek());
    }
}
