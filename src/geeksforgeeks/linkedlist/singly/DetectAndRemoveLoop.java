package geeksforgeeks.linkedlist.singly;

import java.util.HashSet;

public class DetectAndRemoveLoop {
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
        Node newNode = new Node(data);
        newNode.next = head;
        head=newNode;
    }
    public void printList(){
        Node temp = head;
        while(temp != null ){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public void printListUsingHashSet(){
        Node temp = head;
        HashSet<Node> hs = new HashSet<>();
        while(temp!=null){
            if(hs.contains(temp)){
                System.out.print(temp.data+" \n");
                break;
            }
            System.out.print(temp.data+" ");
            hs.add(temp);
            temp = temp.next;
        }
    }
    public boolean detectAndRemoveLoop(){
        Node slowPtr = head, fastPtr = head;
        while(fastPtr != null && fastPtr.next != null ){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                System.out.println("Loop found !! "+slowPtr.data);
                removeLoop(slowPtr);
                return true;
            }
        }
        return false;
    }
    public void removeLoop(Node loopNodePtr){
        Node ptr1 = head;
        while( true ){
            Node ptr2 = loopNodePtr;
            //System.out.println("Ptr1.data: "+ptr1.data+"Ptr2.data: "+ptr2.data);
            while(ptr2.next != loopNodePtr && ptr2.next != ptr1 ){
                ptr2 = ptr2.next;
            }
            if(ptr2.next == ptr1){
                ptr2.next = null;
                break;
            }
            ptr1 = ptr1.next;
        }
    }
    // 50 -> 20 -> 15 -> 4 -> 10
    // 10 -> 4 -> 15 -> 20 -> 50 -> 15
    public static void main(String [] args){
        DetectAndRemoveLoop list = new DetectAndRemoveLoop();
        list.push(50);
        list.push(20);
        list.push(15);
        list.push(4);
        list.push(10);
        // Creating a loop for testing
        list.head.next.next.next.next.next = list.head.next.next;
        list.printListUsingHashSet();
        list.detectAndRemoveLoop();
        System.out.println("Linked List after removing loop : ");
        list.printList();
    }

}
