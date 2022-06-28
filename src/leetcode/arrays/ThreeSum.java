package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/

public class ThreeSum {
	class Solution {
	    public List<List<Integer>> threeSum(int[] nums) {
	        if(nums == null || nums.length < 3){
	            return new ArrayList<>();
	        }
	        int n = nums.length;
	        List<List<Integer>> result = new ArrayList<>();
	        Arrays.sort(nums);
	        for(int i = 0; i < n-2; i++){
	            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
	                int start = i + 1;
	                int end = n - 1;
	                while(start < end){
	                    int sum = nums[i]+nums[start]+nums[end];
	                    if( sum == 0){
	                        result.add(Arrays.asList( nums[i], nums[start], nums[end]));
	                        while(start < end && nums[start] == nums[start+1]){
	                            start++;
	                        }
	                        while(start < end && nums[end] == nums[end-1]){
	                            end--;
	                        }
	                        start++;
	                        end--;
	                    }else if( sum > 0 ){
	                        end--;
	                    }else{
	                        //if(sum < 0){
	                        start++;
	                    }
	                }    
	            }
	        }
	        return result;
	    }
	    
	}
}
