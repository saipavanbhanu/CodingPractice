package leetcode.arrays;

public class FirstMissingPositive41 {class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0)
                nums[i] = 0;
        }
        for(int i = 0; i < n; i++){
            if(Math.abs(nums[i]) > 0 && Math.abs(nums[i]) < n+1 ){
                if ( nums[Math.abs(nums[i]) - 1] == 0){
                    nums[Math.abs(nums[i]) - 1] = -1 * (n+1);
                }else if(nums[Math.abs(nums[i]) - 1] > 0){
                    nums[Math.abs(nums[i]) - 1] *= -1;
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
}}
