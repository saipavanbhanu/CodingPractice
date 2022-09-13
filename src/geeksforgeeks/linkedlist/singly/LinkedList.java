package geeksforgeeks.linkedlist.singly;

public class LinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void printList(Node head){
        Node temp = head;
        while(temp != null ){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String [] args ){
        LinkedList llist = new LinkedList();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        llist.head = first;
        first.next = second;
        second.next = third;
        printList(llist.head);
    }

}
