package geeksforgeeks.linkedlist.singly;

public class LinkedListIsPalindrome {
    Node head;
    Node slowPtr, fastPtr, prevSlowPtr, secondList ;
    class Node{
        char data;
        Node next;
        Node(char data){
            this.data = data;
            this.next = null;
        }
    }
    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        findMiddle();
        Node middleNode=null;
        secondList=slowPtr;
        if(fastPtr != null ){
            middleNode = slowPtr;
            secondList = middleNode.next;
            middleNode.next = null;
        }
        prevSlowPtr.next = null;
        /*System.out.println("first list");
        printList(head);
        System.out.println("second list");
        printList(secondList);*/
        reverse();
        boolean result = compareLists(head, secondList);
        reverse();
        //System.out.println("after reversing second list");
        //printList(secondList);
        if(middleNode != null){
            prevSlowPtr.next = middleNode;
            middleNode.next = secondList;
        }else{
            prevSlowPtr.next = secondList;
        }
        return result;
    }
    public boolean compareLists(Node first, Node second){
        boolean flag = false;
        while(first != null && second != null ){
            if(first.data == second.data ){
                flag = true;
            }else{
                flag = false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        return flag;
    }
    public void reverse(){
        Node reversedList = null;
        Node itr = secondList;
        while(itr != null ){
            Node temp = itr.next;
            itr.next = reversedList;
            reversedList = itr;
            itr = temp;
        }
        secondList = reversedList;
    }
    public void findMiddle(){
        //'a', 'b', 'a', 'c', 'a', 'b', 'a'  slowPtr = c, fastPtr = a
        // 'a', 'b', 'a', 'b'  slowPtr = a, fastPtr = null
        slowPtr = head;fastPtr = head;prevSlowPtr = head;
        while(fastPtr != null && fastPtr.next != null ){
            prevSlowPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
    }
    public void push(char ch){
        Node newNode = new Node(ch);
        newNode.next = head;
        head = newNode;
    }
    public void printList(Node temp){
        Node ptr = temp;
        while(ptr != null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public static void main(String [] args){
        LinkedListIsPalindrome llist = new LinkedListIsPalindrome();
        char str[] = { 'a', 'b', 'c', 'd', 'c', 'b', 'a' };
        String string = new String(str);
        for (int i = 0; i < 7; i++) {
            llist.push(str[i]);
            llist.printList(llist.head);
            if (llist.isPalindrome() != false) {
                System.out.println("Is Palindrome");
                System.out.println("");
            }
            else {
                System.out.println("Not Palindrome");
                System.out.println("");
            }
        }

        //llist.printList(llist.head);
        //System.out.println();
    }
}
