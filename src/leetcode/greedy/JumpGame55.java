package leetcode.greedy;

public class JumpGame55 {
	class Solution {
	    public boolean canJump(int[] nums) {
	        //greedy approach
	        int goal = nums.length-1;
	        for(int i = nums.length-1; i >= 0; i--){
	            if(i + nums[i] >= goal ){
	                goal = i;
	            }
	        }
	        return goal == 0;
	    }
	}
}
