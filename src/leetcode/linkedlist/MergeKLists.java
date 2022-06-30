package leetcode.linkedlist;

public class MergeKLists {
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
	    public ListNode mergeKLists(ListNode[] lists) {
	        if(lists == null || lists.length == 0){
	           return null;
	        }else if(lists.length == 1){
	           return lists[0];
	        }
	        Heap heap = new Heap(lists.length);
	        head = null; tail = null;
	        
	        for(int i = 0; i < lists.length; i++){
	            if(lists[i]!=null)
	               heap.add(lists[i]);
	        } 
	       
	        while(!heap.isEmpty()){
	            ListNode node = heap.pop();
	            ListNode nextNode = node.next;
	            node.next = null;
	            addToResult(node);
	            if(nextNode != null){
	                heap.add(nextNode);
	            }
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
	class Heap{
	    int size;
	    int capacity;
	    ListNode[] arr;
	    Heap(int c){
	        capacity = c;
	        arr = new ListNode[capacity];
	        size = 0;
	    }
	    void print(){
	        for(int i = 0; i < size; i++){
	            System.out.print(arr[i].val+",");
	        }
	        System.out.println();
	    }
	    int left(int i){
	        return 2 * i + 1;
	    }
	    int right(int i){
	        return 2 * i + 2;
	    }   
	    int parent(int i){
	        return (i - 1)/2;
	    }
	    boolean isEmpty(){
	        if(size == 0){
	            return true;
	        }
	        return false;
	    }
	    
	    void add(ListNode node){ //add the node to last and balance it from bottom to top
	        arr[size] = node;
	        size++;
	        balanceBottomUp(size-1);
	        //print();
	    }
	    ListNode pop(){
	        ListNode node = arr[0];
	        arr[0] = arr[size-1];
	        size--;
	        balanceTopDown(0);
	        return node;
	    }
	    void balanceTopDown(int index){
	        int lI = left(index);
	        int rI = right(index);
	        ListNode node = arr[index];
	        int unBalancedIndex = index;
	        if(lI < size && arr[lI].val < node.val){
	            node = arr[lI];
	            unBalancedIndex = lI;
	        }
	        if(rI < size && arr[rI].val < node.val){
	            node = arr[rI];
	            unBalancedIndex = rI;
	        }
	        if(node != arr[index]){
	            //swap the index node with the unBalancedIndex
	            ListNode temp = arr[index];
	            arr[index] = arr[unBalancedIndex];
	            arr[unBalancedIndex] = temp;
	            balanceTopDown(unBalancedIndex);
	        }
	    }
	    void balanceBottomUp(int index){
	        if(index == 0)
	            return;
	        int pI = parent(index);
	        if(pI >= 0){
	            //System.out.println("parent index: "+pI);
	            ListNode parent = arr[pI];
	            ListNode node = arr[index];
	            if(node.val < parent.val){
	                //swap the nodes
	                //System.out.println("inside");
	                ListNode temp = arr[pI];
	                arr[pI] = arr[index];
	                arr[index] = temp;
	                balanceBottomUp(pI);
	            }
	        }
	        
	    }
	}

}
