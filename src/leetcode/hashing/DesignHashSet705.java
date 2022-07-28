package leetcode.hashing;

import java.util.ArrayList;
import java.util.List;

public class DesignHashSet705 {
	class MyHashSet {
	    List<Integer>[] buckets;
	    public MyHashSet() {
	        buckets = new ArrayList[1500000];
	    }
	    private int hash(int key){
	        return key % 1500000;
	    }
	    public void add(int key) {
	        int hash = hash(key);
	        if(buckets[hash] == null){
	            buckets[hash] = new ArrayList<>();
	        }
	        if(buckets[hash].contains(key) == false){
	            buckets[hash].add(key);
	        }
	    }
	    
	    public void remove(int key) {
	        int hash = hash(key);
	        if(buckets[hash] == null){
	            //doesn't contain;
	        }else{
	            buckets[hash].remove(Integer.valueOf(key));
	        }
	    }
	    
	    public boolean contains(int key) {
	        int hash = hash(key);
	        if(buckets[hash] == null){
	            return false;
	        }else{
	            return buckets[hash].contains(key);
	        }
	    }
	}

	/**
	 * Your MyHashSet object will be instantiated and called as such:
	 * MyHashSet obj = new MyHashSet();
	 * obj.add(key);
	 * obj.remove(key);
	 * boolean param_3 = obj.contains(key);
	 */
}
