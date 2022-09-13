package utilities.util.queue;
import java.util.PriorityQueue;
public class PriorityQueueUsage {
    public static void main(String [] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(2);
        pq.add(10);
        System.out.println(pq);
        System.out.println("Peek :: "+pq.peek());
        System.out.println("Removed element :: "+pq.remove());
        System.out.println("After removing ::"+pq);
    }
}
