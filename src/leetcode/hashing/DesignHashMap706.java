package leetcode.hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DesignHashMap706 {
	class MyHashMap {
		static class Pair {
			int k, v;
			Pair(int k, int v) {
				this.k = k;
				this.v = v;
			}
			@Override
			public int hashCode() {
				return Objects.hash(k);
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Pair other = (Pair) obj;
				return k == other.k;
			}
		}
        List<Pair>[] buckets;
		final static int BUCKET_SIZE = 1000000;
        public MyHashMap() {
            buckets = new ArrayList[BUCKET_SIZE];
		}
        
		public void put(int key, int value) {
            int bucketIndex = hash(key);
            if(buckets[bucketIndex] == null){
                buckets[bucketIndex] = new ArrayList<Pair>();
                buckets[bucketIndex].add(new Pair(key, value));
            }else{
                Pair p = new Pair(key, value);
                boolean found = false;
                for(Pair obj : buckets[bucketIndex]){
                    if(obj.equals(p)){
                        obj.v = p.v;
                        found = true;
                        break;
                    }else{
                        found = false;
                        continue;
                    }
                }
                if(found == false){
                    buckets[bucketIndex].add(p);
                }
            }
            
            
		}

		public int get(int key) {
            int bucketIndex = hash(key);
            if(buckets[bucketIndex] == null){
                return -1;
            }else{
                for(Pair obj : buckets[bucketIndex]){
                    if(obj.k == key){
                        return obj.v;
                    }
                }
                return -1;
            }
		}

		public void remove(int key) {
            int bucketIndex = hash(key);
            if(buckets[bucketIndex] == null){
                //do nothing.
            }else{
                for(int i = 0; i < buckets[bucketIndex].size(); i++){
                    if(buckets[bucketIndex].get(i).k == key){
                        buckets[bucketIndex].set(i, buckets[bucketIndex].get(buckets[bucketIndex].size()-1));
                        buckets[bucketIndex].remove(buckets[bucketIndex].size()-1);
                        return;
                    }
                }
            }
		}
        private int hash(int key){
            return Objects.hash(key)%BUCKET_SIZE;
        }
	}

	/**
	 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
	 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
	 * obj.remove(key);
	 */
}
