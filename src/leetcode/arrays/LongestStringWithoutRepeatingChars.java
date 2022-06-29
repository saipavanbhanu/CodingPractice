package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestStringWithoutRepeatingChars {
	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        if(s == null || s.length() == 0){
	            return 0;
	        }
	        int length = s.length();
	        Set<Character> set = new HashSet<>(length);
	        set.add(s.charAt(0));
	        int start = 0;
	        int longest = 1;
	        for(int i = 1; i < length; i++){
	            char ch = s.charAt(i);
	            if(set.contains(ch)){
	                //remove chars from start to first appearance of ch
	                if(longest < set.size()){
	                    longest = set.size();
	                }
	                boolean found = false;
	                while(found == false){
	                    if(s.charAt(start) == ch){
	                        found = true;
	                    }
	                    set.remove(s.charAt(start));
	                    start++;
	                }
	                
	                set.add(ch);
	            }else{
	                set.add(ch);
	                if(longest < set.size()){
	                    longest = set.size();
	                }
	            }
	        }
	        if(longest < set.size()){
	            longest = set.size();
	        }
	        return longest;
	    }
	}
}
