package leetcode.arrays;
//https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {
	class Solution {
	    public int[] productExceptSelf(int[] nums) {
	        if(nums == null || nums.length ==  0){
	            return null;
	        }
	        
	        int []result = new int[nums.length];
	        int left = 1;
	        result[0] = 1;
	        for(int i = 1; i < nums.length; i++){
	            result[i] = left * nums[i-1];
	            left = left * nums[i-1];
	        }
	        
	        int right = 1;
	        for(int i = nums.length-2; i >= 0; i--){
	            result[i] = result[i] * right * nums[i+1];
	            right = right * nums[i+1];
	        }
	        
	        return result;
	    }
	}
}
