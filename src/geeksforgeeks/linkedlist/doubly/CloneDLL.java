package geeksforgeeks.linkedlist.doubly;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/

public class CloneDLL {
    Node head;//Linked list head reference
    static class Node {
        int data;//Node data
        Node next, random;//Next and random reference
        Node(int data) {
            this.data = data;
            this.next = this.random = null;
        }
    }
    CloneDLL(Node head) {
        this.head = head;
    }
    public void push(int data) {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }
    void print() {
        Node temp = head;
        while (temp != null) {
            Node random = temp.random;
            int randomData = (random != null)? random.data: -1;
            System.out.println("Data = " + temp.data +
                    ", Random data = "+ randomData);
            temp = temp.next;
        }
    }
    public CloneDLL clone(){ //clone the dll in O(1)
        Node first = this.head, second = null;
        while(first !=null){
            Node temp = new Node(first.data);
            temp.next = first.next;
            first.next = temp;
            first = first.next.next;
        }
        first = this.head;
        while(first != null){
            first.next.random = first.random.next;
            first = first.next.next;
        }

        first = this.head;
        Node copy = this.head.next;
        second = this.head.next;
        while(first != null ){
            first.next = first.next.next;
            if(second.next == null ){
                second.next = null;
            }else{
                second.next = second.next.next;
            }

            first = first.next;
            second = second.next;
        }

        return new CloneDLL(copy);
    }
    public CloneDLL cloneUsingMap(){
        Node originalList = this.head;
        Node cloneList = null;
        Map<Node,Node> map = new HashMap<>();

        while(originalList != null ){
            Node cloneNode = new Node(originalList.data);
            map.put(originalList, cloneNode);
            originalList = originalList.next;
        }

        originalList = this.head;
        while(originalList != null ){
            Node cloneNode = map.get(originalList);
            cloneNode.next = map.get(originalList.next);
            cloneNode.random = map.get(originalList.random);
            originalList = originalList.next;
        }
        return new CloneDLL(map.get(this.head));
    }
    public static void main(String [] args){
        CloneDLL list = new CloneDLL(new Node(5));
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        list.head.random = list.head.next.next;
        list.head.next.random =
                list.head.next.next.next;
        list.head.next.next.random =
                list.head.next.next.next.next;
        list.head.next.next.next.random =
                list.head;
        list.head.next.next.next.next.random =
                list.head.next;

        // Making a clone of the original linked list.
        CloneDLL cloneUsingMap = list.cloneUsingMap();
        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print();
        System.out.println("\nCloned linked list");
        cloneUsingMap.print();
        System.out.println();
        CloneDLL clone = list.clone();  //
        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print();
        System.out.println("\nCloned linked list");
        clone.print();

    }

}
