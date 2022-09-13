package leetcode.linkedlist;

public class ConvertBinaryNumberinaLinkedListtoInteger1290 {
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
	    int power = 0;
	    public int getDecimalValue(ListNode node) {
	        if(node == null){
	            return 0;
	        }else{
	            int val = getDecimalValue(node.next);
	            double returnValue = node.val * Math.pow(2, power) + val;
	            power++;
	            return (int) returnValue;
	        }    
	    }
	}
}
