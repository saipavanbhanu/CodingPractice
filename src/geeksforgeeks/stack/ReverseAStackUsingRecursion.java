package geeksforgeeks.stack;
import java.util.Stack;

public class ReverseAStackUsingRecursion {
    static Stack<Character> st = new Stack<>();

    public static void insertAtBottom(char x){
        if(st.size() > 0){
            char temp = st.pop();
            insertAtBottom(x);
            st.push(temp);
        }else{
            st.push(x);
        }
    }

    public static void reverse(){
        if(st.size()> 0){
            char temp = st.pop();
            reverse();
            insertAtBottom(temp);
        }
    }

    public static void main(String [] args){
        // push elements into
        // the stack
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
        System.out.println("Original Stack");
        System.out.println(st);
        // function to reverse
        // the stack
        reverse();
        System.out.println("Reversed Stack");
        System.out.println(st);

    }
}
