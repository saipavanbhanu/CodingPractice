package leetcode.arrays.slidingwindow;

public class MaximumPointsYouCanObtainFromCards {
	class Solution {
	    public int maxScore(int[] cardPoints, int k) {
	        int n = cardPoints.length;
	        //sliding window
	        int left = 0, right = n - k - 1;
	        int result = 0;
	        for(int i = right+1; i < n; i++){
	            result = result + cardPoints[i];
	        }
	        int sum = result;
	        //System.out.println(result);
	        while(right < n-1){
	            sum = sum - cardPoints[right+1] + cardPoints[left]; 
	            if(sum > result){
	                result = sum;
	            }
	            left++;
	            right++;
	        }
	        return result;
	    }
	}
}
