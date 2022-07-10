package leetcode.arrays;
//https://leetcode.com/problems/find-the-duplicate-number/
/*
 * using the slow and fast pointer (Cycle detection in linkedlist)
 *  technique to find the duplicate no without using extra space*/
public class FindTheDuplicateNumber {
	class Solution {
	    public int findDuplicate(int[] nums) {
	        //similar to cycle detection algorithm using slow and fast pointer.
	        int slow = nums[0];
	        int fast = nums[0];
	        do{
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        }while(slow != fast);
	        //after the loop they meet inside the cycle.
	        slow = nums[0];
	        while(slow != fast){
	            slow = nums[slow];
	            fast = nums[fast];
	        }
	        return slow;
	    }
	}
}
