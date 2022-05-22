package utilities.util.stack;
import java.util.Stack;
public class StackUsage {
    public static void main(String [] args){
        //Stack class shouldn't be used as it as Legacy class
        //Alternative for this is Deque(I)
        //Implementation class is LinkedList
        Stack<Integer> stack = new Stack<>();
        for(int i = 5; i > 0; i--){
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        //empty()
        //search(Object obj)
    }
}
