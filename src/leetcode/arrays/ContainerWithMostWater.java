package leetcode.arrays;

public class ContainerWithMostWater {
	class Solution {
	    public int maxArea(int[] height) {
	        if(height == null || height.length == 0){
	            return 0;
	        }
	        int maxArea = 0;
	        int left = 0, right = height.length-1;
	        
	        while(left < right){
	            int currentArea = ( right - left ) * Math.min(height[left], height[right]);
	            if(currentArea > maxArea){
	                maxArea = currentArea;
	            }
	            
	            if(height[left] < height[right]){
	                left++;    
	            }else
	                right--;
	        }
	        return maxArea;
	    }
	}
}
