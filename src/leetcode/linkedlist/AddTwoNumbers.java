package leetcode.linkedlist;
class ListNode{
	int val;
	ListNode next;
	ListNode(int data, ListNode next){
		val = data;
		this.next = next;
	}
}
public class AddTwoNumbers {

}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode result, tail;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null ){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        result = null; tail = null;
        int carry = 0, value = 0;
        while(l1 != null && l2 != null){
            value = carry + l1.val + l2.val;
            carry = ( carry + l1.val + l2.val )/10;
            if(carry > 0){
                insertAtTheEnd(value-10);
            }else{
                insertAtTheEnd(value);
            }
            l1 = l1.next;
            l2 = l2.next;
        } 
        
        //if any of the given list are empty
        while(l1 != null){
            value = carry + l1.val ;
            carry = ( carry + l1.val )/10;
            if(carry > 0)
                insertAtTheEnd(value-10);    
            else
                insertAtTheEnd(value);
            
            l1 = l1.next;
        }
        
        while(l2 != null){
            value = carry + l2.val ;
            carry = ( carry + l2.val )/10;
            if(carry > 0)
                insertAtTheEnd(value-10);    
            else
                insertAtTheEnd(value);
            
            l2 = l2.next;
        }
        
        if(carry > 0){
            insertAtTheEnd(carry);    
        }
        
        return result;
    }
    
    private void insertAtTheEnd(int value){
        ListNode node = new ListNode(value, null);
        if(result == null && tail == null){
            result = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }
}