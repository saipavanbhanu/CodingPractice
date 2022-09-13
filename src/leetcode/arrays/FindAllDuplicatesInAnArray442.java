package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray442 {
	class Solution {
	    public List<Integer> findDuplicates(int[] nums) {
	        List<Integer> result = new ArrayList<>(nums.length);
	        for(int i = 0; i < nums.length; i++){
	            int no = Math.abs(nums[i]);
	            if(nums[no-1] < 0){
	                result.add(Math.abs(nums[i]));
	            }else{
	                nums[no-1] = nums[no-1]*(-1);
	            }
	        }
	        return result;
	    }
	}
}
