package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//https://leetcode.com/problems/insert-delete-getrandom-o1/

public class InsertDeleteGetRandom {
	class RandomizedSet {
	    Map<Integer, Integer> indexMap;
	    List<Integer> nos = new ArrayList<>();
	    Random rand = new Random();
	    public RandomizedSet() {
	        indexMap = new HashMap<>();
	    }
	    public boolean insert(int val) {
	        if(indexMap.containsKey(val)){
	            return false;
	        }else{
	            nos.add(val);
	            //System.out.println("insert:"+nos);
	            indexMap.put(val,nos.size()-1);
	            return true;
	        }
	    }
	    
	    public boolean remove(int val) {
	        //System.out.println("remove"+val);
	        if(indexMap.containsKey(val)){
	            int index = indexMap.get(val);
	            int lastIndex = nos.size()-1;
	            if(index != lastIndex){
	                //System.out.println("("+index+","+lastIndex+")");
	                int lastElement = nos.get(lastIndex);
	                //System.out.println("last:"+lastElement);
	                nos.set(index, lastElement);
	                indexMap.put(lastElement, index);
	                //System.out.println("after"+nos);
	                nos.remove(lastIndex);
	                //System.out.println("after1"+nos);
	            }else{
	                nos.remove(index);
	            }
	            indexMap.remove(val);
	            return true;
	        }else{
	            return false;
	        }        
	    }
	    public int getRandom() {
	        int index = rand.nextInt(nos.size());
	        //System.out.println(index+"list:"+ nos);
	        return nos.get(index);
	    }
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet();
	 * boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val);
	 * int param_3 = obj.getRandom();
	 */
}
