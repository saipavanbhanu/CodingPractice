package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	class Solution {
	    int[] candidates;
	    List<List<Integer>> result;
	    
	    private void backtrack(int i, List<Integer> s, int t){
	        if(t == 0){
	            result.add(new ArrayList<>(s));
	            return;
	        }    
	        if( t < 0){
	            return;
	        }
	        if( i == candidates.length){
	            return;
	        }
	        
	        //skip the ith candidate
	        backtrack(i+1, s, t);
	        
	        //take ith candidate into consideration
	        s.add(candidates[i]);
	        backtrack(i, s, t-candidates[i]);
	        s.remove(s.size()-1);
	    }
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        this.candidates = candidates;
	        result = new LinkedList<>();
	        List<Integer> solution = new ArrayList<>(candidates.length);
	        backtrack(0, solution, target);
	        return result;
	    }
	}
}
