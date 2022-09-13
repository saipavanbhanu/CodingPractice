package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int resultSize = (int)Math.pow(2,n);
        result = new ArrayList<>(resultSize);
        int binary[] = new int[nums.length];
        
        binary[0] = 0;
        backtracking(1, nums, binary);
        binary[0] = 1;
        backtracking(1, nums, binary);
        
        return result;
    }
    
    private void backtracking(int index, int[] nums, int[] binary){
        if(index == nums.length){
            List<Integer> list = new ArrayList<>(nums.length);
            for(int i = 0; i < nums.length; i++){
                if(binary[i] == 1){
                    list.add(nums[i]);
                }
            }
            result.add(list);
        }else{
            binary[index]=0;
            backtracking(index+1, nums, binary);
            binary[index]=1;
            backtracking(index+1, nums, binary);
        }
    }
}}
