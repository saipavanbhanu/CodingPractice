package leetcode.arrays;

public class MoveZeroes {

	class Solution {
	    public void moveZeroes(int[] nums) {
	        if(nums == null || nums.length == 0 ){
	            return;
	        }
	        
	        int len = nums.length;
	        int count = 0; //zero's count;
	        for(int i = 0; i < len; i++){
	            if(nums[i] == 0){
	                count++;
	            }
	        }
	        
	        int nonZeros = len - count;
	        int index = 0;
	        int i = 0;
	        for(i = 0; i < len && index < nonZeros; i++){
	            if(nums[i] != 0){
	                nums[index++] = nums[i];
	            }
	        }
	        
	        i = nonZeros;
	        for(; i < len; i++){
	            nums[i] = 0;
	        }
	        
	    }
	}
	
}
