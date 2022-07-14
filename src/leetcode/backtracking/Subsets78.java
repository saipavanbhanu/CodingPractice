package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
	class Solution {
	    public List<List<Integer>> subsets(int[] nums) {
	        int n = nums.length;
	        int resultSize = (int)Math.pow(2,n);
	        List<List<Integer>> result = new ArrayList<>(resultSize);
	        
	        for(int i = 0; i < resultSize; i++){
	            result.add(getArray(i, nums));
	        }
	        return result;
	    }
	    private List<Integer> getArray(int no, int[]nums){
	        List<Integer> arr = new ArrayList<>(nums.length);
	        String binary = Integer.toBinaryString(no);
	        int binaryIndex = binary.length()-1;
	        for(int i = 0; i < nums.length; i++){
	            int isSet = 0;
	            if(binaryIndex >= 0){
	                isSet = binary.charAt(binaryIndex)-'0';
	            }else{
	                isSet = 0;
	            }
	            if(isSet != 0 )
	                arr.add(nums[i]*isSet);
	            binaryIndex--;
	        }
	        return arr;
	    }
	}
}
