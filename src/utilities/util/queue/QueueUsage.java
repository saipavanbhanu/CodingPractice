package utilities.util.queue;
import java.util.Queue;
import java.util.LinkedList;
public class QueueUsage {
    public static void main(String []args){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            queue.add(i);
        }
        System.out.println(queue);
        int removedElement = queue.remove();
        System.out.println("removed element :: "+removedElement);
        System.out.println("After removing Queue ::"+queue);
        int head = queue.peek();
        System.out.println("Head of the queue:: "+head);
        int size = queue.size();
        System.out.println("queue size :: "+size);

    }
}
