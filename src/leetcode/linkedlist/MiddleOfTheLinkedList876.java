package leetcode.linkedlist;

public class MiddleOfTheLinkedList876 {
	
	class Solution {
	    public ListNode middleNode(ListNode head) {
	        if(head == null || head.next == null){
	            return head;
	        }else{
	            ListNode slow, fast;
	            slow = fast = head;
	            while(fast != null && fast.next != null ){
	                slow = slow.next;
	                fast = fast.next.next;
	            }
	            return slow;
	        }
	    }
	}
}
