package leetcode.arrays;

import java.util.Arrays;

public class ThreeSumClosest {
	class Solution {
	    public int threeSumClosest(int[] nums, int target) {
	        Arrays.sort(nums);
	        //System.out.println(Arrays.toString(nums));
	        int n = nums.length;
	        int min = Integer.MAX_VALUE;
	        int minSum = 0;
	        for(int first = 0; first < n-2; first++){
	            int second = first+1;
	            int third = n-1;
	            while(second < third){
	                int sum = nums[first]+nums[second]+nums[third];
	                int diff = sum - target;
	                //update min
	                if(Math.abs(diff) < min){
	                    min = Math.abs(diff);
	                    minSum = sum;
	                }
	                if(min == 0){
	                    break;
	                }
	                if(diff < 0){
	                    second++;
	                }else{
	                    third--;
	                }
	            }
	        }
	        return minSum;
	    }
	}
}
