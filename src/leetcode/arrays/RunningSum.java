package leetcode.arrays;

public class RunningSum {
	class Solution {
	    public int[] runningSum(int[] nums) {
	        if(nums == null || nums.length == 0){
	            return nums;
	        }
	        int []runningSum = new int[nums.length];
	        int sum = 0;
	        for(int i = 0; i < nums.length; i++){
	            sum = sum + nums[i];
	            runningSum[i] = sum;
	        }
	        return runningSum;
	    }
	}
}
