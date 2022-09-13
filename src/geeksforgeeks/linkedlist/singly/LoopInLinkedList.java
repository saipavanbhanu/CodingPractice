package geeksforgeeks.linkedlist.singly;
import java.util.HashSet;
public class LoopInLinkedList {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void push(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    public boolean floydCycleAlgorithm(){
        Node slowPtr=head, fastPtr = head;
        while(slowPtr != null && fastPtr != null){
            if(slowPtr == fastPtr){
                return true;
            }
            slowPtr = slowPtr.next;
            if(fastPtr.next != null){
                fastPtr = fastPtr.next.next;
            }else{
                fastPtr = fastPtr.next;//or simply assign null
            }
        }
        return false;
    }
    public boolean detectLoop(){
        if(head == null)
            return false;
        HashSet<Node> hs = new HashSet<>();
        Node temp = head;
        while(temp != null ){
            if ( hs.contains(temp) ){
                return true;
            }
            hs.add(temp);
            temp = temp.next;
        }
        return false;
    }
    public static void main(String [] args ){
        LoopInLinkedList llist = new LoopInLinkedList();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);
        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;
        boolean flag = llist.floydCycleAlgorithm();
        //llist.detectLoop()
        if (flag)
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
    }
}
