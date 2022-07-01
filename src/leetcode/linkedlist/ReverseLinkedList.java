package leetcode.linkedlist;

public class ReverseLinkedList {
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
	    public ListNode reverseList(ListNode head) {
	        ListNode result = null;
	        ListNode node = head;
	        while(node != null){
	            ListNode nextNode = node.next;
	            node.next = null;
	            if(result == null){
	                result = node;
	            }else{
	                node.next = result;
	                result = node;
	            }
	            node = nextNode;
	        }
	        return result;
	    }
	}
}
