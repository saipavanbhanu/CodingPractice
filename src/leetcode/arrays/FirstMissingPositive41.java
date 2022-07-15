package leetcode.arrays;

public class FirstMissingPositive41 {
	class Solution {
	    public int firstMissingPositive(int[] nums) {
	        int n = nums.length;
	        for(int i = 0; i < n; i++){
	            if(nums[i] < 0)
	                nums[i] = 0;
	        }
	        for(int i = 0; i < n; i++){
	            int abs = Math.abs(nums[i]);
				if(abs > 0 && abs < n+1 ){
	                if ( nums[abs - 1] == 0){
	                    nums[abs - 1] = -1 * (n+1);
	                }else if(nums[abs - 1] > 0){
	                    nums[abs - 1] *= -1;
	                } 
	            }
	        }
	        int i;
	        for(i = 1; i <= n; i++){
	            if(nums[i-1] < 0){
	                continue;
	            }else{
	                return i;
	            }
	        }
	        return i;
	    }
	}
}
