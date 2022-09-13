package leetcode.linkedlist;

public class ReverseNodesInKGroup25 {
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
	    static class Pair{
	        ListNode list1;
	        ListNode list2;
	        Pair(ListNode list1, ListNode list2){
	            this.list1 = list1;
	            this.list2 = list2;
	        }
	    }
	    int len, k;
	    ListNode resultHead, resultTail;
	    public ListNode reverseKGroup(ListNode head, int k) {
	        this.k = k;
	        len = length(head);
	        resultHead = resultTail = null;
	        if(len < k){
	            return head;
	        }else{
	            ListNode iter = head;
	            int currLen = len;
	            while(currLen >= k ){
	                //System.out.println(currLen);
	                Pair p = divide(iter);
	                append( reverse(p.list1) );
	                iter = p.list2;
	                currLen -= k;
	            }
	            if(currLen > 0){
	                append(iter);
	            }
	            return resultHead;
	        }
	    }
	    void append(ListNode node){
	        if(resultHead == null){
	            resultHead = node;
	            ListNode iter = node;
	            while(iter.next != null){
	                iter = iter.next;
	            }
	            resultTail = iter;
	        }else{
	            resultTail.next = node;
	            ListNode iter = node;
	            while(iter.next != null){
	                iter = iter.next;
	            }
	            resultTail = iter;
	        }
	    }
	    void print(ListNode head){
	        StringBuilder sb = new StringBuilder();
	        while(head != null){
	            sb.append(head.val+",");
	            head = head.next;
	        }
	        System.out.println(sb.toString());
	    }
	    ListNode reverse(ListNode head){
	        if(head == null){
	            return head;
	        }
	        //print(head);
	        ListNode result = null;
	        ListNode resultTail = null;
	        ListNode iter = head;
	        while(iter != null){
	            ListNode iterNext = iter.next;
	            iter.next = null;
	            if(result == null){
	                result = iter;
	                resultTail = iter;
	            }else{
	                iter.next = result;
	                result = iter;
	                //resultTail.next = iter;
	            }
	            iter = iterNext;
	        }
	        //System.out.print("after reverse:");
	        //print(result);
	        return result;
	    }
	    int length(ListNode head){
	        if(head == null){
	            return 0;
	        }else{
	            ListNode iter = head;
	            int count = 0;
	            while(iter != null){
	                iter = iter.next;
	                count++;
	            }
	            return count;
	        }
	    }
	    Pair divide(ListNode head){
	        ListNode iter = head;
	        int count = k;
	        while(count > 1){
	            iter = iter.next;
	            count--;
	        }
	        ListNode list2 = iter.next;
	        iter.next = null;
	        return new Pair( head, list2);
	    }
	    
	    
	}
}
