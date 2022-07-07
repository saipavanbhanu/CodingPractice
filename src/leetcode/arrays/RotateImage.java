package leetcode.arrays;

public class RotateImage {
	//https://leetcode.com/problems/rotate-image/
	//https://www.youtube.com/watch?v=fMSJSS7eO1w&ab_channel=NeetCode
	class Solution {
	    public void rotate(int[][] matrix) {
	        int left = 0, right = matrix.length-1;
	        
	        while(left < right){
	            int top = left, bottom = right;
	            
	            for(int i = 0; i < right - left; i++){
	                //store top left to temporary variable
	                int topLeft = matrix[top][left+i];
	                
	                //store bottom left to top left
	                matrix[top][left+i] = matrix[bottom-i][left];
	                
	                //store bottom right to bottom left
	                matrix[bottom-i][left] = matrix[bottom][right-i];
	                
	                //store top right to bottom right
	                matrix[bottom][right-i] = matrix[top+i][right];
	                
	                //store top left to top right
	                matrix[top+i][right] = topLeft;
	                
	            }
	            
	            left++;
	            right--;
	        }
	        
	    }
	}
}
