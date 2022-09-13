package leetcode.arrays;

public class MajorityElement {
	class Solution {
	    public int majorityElement(int[] nums) {
	        int c = 0, v = 0;
	        for(int i = 0; i < nums.length; i++){
	            if(v == 0){
	                c = nums[i];
	            }
	            if(c == nums[i]){
	                v++;
	            }else{
	                v--;
	            }
	        }
	        return c;
	    }
	}
}
