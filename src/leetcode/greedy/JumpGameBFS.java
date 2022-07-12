package leetcode.greedy;

public class JumpGameBFS {
	class Solution {
	    public int jump(int[] nums) {
	        int left = 0, right = 0;
	        int levelCount = 0;
	        //similar approach like bfs
	        while(right < nums.length - 1){
	            int farthest = 0;
	            for(int i = left; i <= right; i++){
	                farthest = Math.max(farthest, i + nums[i]);
	            }
	            left = right + 1;
	            right = farthest;
	            levelCount++;
	        }
	        return levelCount;
	    }
	}
}
