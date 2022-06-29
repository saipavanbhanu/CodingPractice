package leetcode.linkedlist;
//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
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
	    ListNode head, tail;
	    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	        if(list1 == null){
	            return list2;
	        }else if(list2 == null){
	            return list1;
	        }
	        head = tail = null;
	        while(list1 != null && list2 != null){
	            if(list1.val <= list2.val){
	                ListNode node = list1;
	                list1 = list1.next;
	                node.next = null;
	                addToResult(node);
	            }else{
	                ListNode node = list2;
	                list2 = list2.next;
	                node.next = null;
	                addToResult(node);
	            }
	        }
	        while(list1 != null){
	            ListNode node = list1;
	            list1 = list1.next;
	            node.next = null;
	            addToResult(node);
	        }
	        while(list2 != null){
	            ListNode node = list2;
	            list2 = list2.next;
	            node.next = null;
	            addToResult(node);
	        }
	        return head;
	    }
	    private void addToResult(ListNode node){
	        if(head == null && tail == null){
	            head = tail = node;
	        }else{
	            tail.next = node;
	            tail = tail.next;
	        }
	    }
	}
}
