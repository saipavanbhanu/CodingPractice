package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

	class Solution {
	    public List<List<Integer>> generate(int numRows) {
	        if(numRows == 1){
	            return Arrays.asList(Arrays.asList(1));
	        }else if(numRows == 2){
	            return Arrays.asList(Arrays.asList(1), Arrays.asList(1,1));
	        }
	        List<List<Integer>> result = new ArrayList<>(numRows);
	        result.add(Arrays.asList(1));
	        result.add(Arrays.asList(1,1));
	        List<Integer> store = Arrays.asList(1,1);
	        //List<Integer> newStore = new ArrayList<>(numRows);
	        int times = numRows - 2;
	        while( times > 0 ){
	            List<Integer> newStore = new ArrayList<>(numRows);
	            newStore.add(1);
	            for(int i = 0; i < store.size() - 1; i++){
	                newStore.add(store.get(i)+store.get(i+1));
	            }
	            newStore.add(1);
	            result.add(newStore);
	            store = newStore;
	            times--;
	        }
	        return result;
	    }
	}
}
