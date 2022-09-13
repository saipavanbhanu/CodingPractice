package leetcode.linkedlist;

public class LinkedListCycle141 {
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        if(head == null || head.next == null){
	            return false;
	        }
	        
	        ListNode slow, fast;
	        slow = fast = head;
	        do{
	            slow = slow.next;
	            fast = fast.next.next;
	        }while( !(fast == null || fast.next == null ) && slow != fast);
	        if(slow == fast){
	            return true;
	        }else{
	            return false;
	        }
	    }
	}
}
