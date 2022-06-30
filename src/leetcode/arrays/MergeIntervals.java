package leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

	class Interval implements Comparable<Interval>{
	    int start;
	    int end;
	    Interval(int s, int e){
	        start = s;
	        end = e;
	    }
	    public int compareTo(Interval i){
	        return this.start - i.start;
	    }
	    public String toString(){
	        return "["+start+","+end+"]";
	    }
	}
	class Solution {
	    List<Interval> list;
	    public int[][] merge(int[][] intervals) {
	        if(intervals == null || intervals.length == 0 ){
	            return null;
	        }
	        int length = intervals.length;
	        list = new ArrayList<>(length);
	        for(int i = 0; i < length; i++){
	            if(intervals[i] != null)
	                list.add(new Interval(intervals[i][0], intervals[i][1]));
	        }
	        Collections.sort(list);
	        //System.out.println("after sorting:"+list);
	        for(int i = 0; i < list.size() - 1; ){
	            if(isMergeable(i, i+1)){
	                Interval first = list.get(i);
	                Interval second = list.get(i+1);
	                if(second.end > first.end)
	                    first.end = second.end;
	                list.remove(i+1);
	                //System.out.println("after merge:"+list);
	            }else{
	                i++;
	            }
	        }
	        return toArray();
	    }
	    private boolean isMergeable(int i, int j){
	        Interval first = list.get(i);
	        Interval second = list.get(j);
	        if(second.start >= first.start && second.start <= first.end){
	            return true;
	        }
	        return false;
	    }
	    private int[][] toArray(){
	        if(list == null || list.size() == 0){
	            return null;
	        }
	        //System.out.println("to array:"+list);
	        int [][] arr = new int[list.size()][2];
	        for(int i = 0; i < list.size(); i++){
	            arr[i][0] = list.get(i).start;
	            arr[i][1] = list.get(i).end;
	        }
	        return arr;
	    }
	}
}
