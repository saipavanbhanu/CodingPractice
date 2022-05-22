package geeksforgeeks.linkedlist.singly;

public class MergeSortOnLinkedList {
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
    public void printList(Node head){
        while(head != null ){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public Node mergeSort(Node head){
        if(head == null || head.next == null ){
            return head;
        }
        Node middle = findMiddle(head);
        Node nextMiddle = middle.next;
        middle.next = null;
        /*System.out.println("first half");
        printList(head);
        System.out.println("second half");
        printList(nextMiddle);
        System.out.println();
*/
        Node firstHalf = mergeSort(head);
        Node secondHalf = mergeSort(nextMiddle);

        Node secondList = sortedMerge(firstHalf, secondHalf);
        return secondList;
    }
    public Node sortedMerge(Node firstHalf, Node secondHalf){
        Node result = null;
        if(firstHalf == null ){
            return secondHalf;
        }
        if(secondHalf == null ){
            return firstHalf;
        }
        if(firstHalf.data < secondHalf.data){
            result = firstHalf;
            result.next = sortedMerge(firstHalf.next, secondHalf);
        }else{
            result = secondHalf;
            result.next = sortedMerge(firstHalf, secondHalf.next);
        }
        return result;
    }
    public Node findMiddle(Node head){
        Node slowPtr = head, fastPtr = head;
        while(fastPtr.next != null && fastPtr.next.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
    public static void main(String [] args){
        MergeSortOnLinkedList li = new MergeSortOnLinkedList();
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);

        li.printList(li.head);
        // Apply merge Sort
        li.head = li.mergeSort(li.head);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);
    }
}
