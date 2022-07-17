package leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber17 {
	class Solution {
	    List<String> result;
	    Map<Character, String> numberLetterMap;
	    public List<String> letterCombinations(String digits) {
	        if(digits.length() == 0){
	            return new ArrayList<>();
	        }
	        init(digits);
	        StringBuilder sb = new StringBuilder(4);
	        letterUtil(digits, 0, sb);
	        return result;
	    }
	    private void letterUtil(String digits, int digitIndex, StringBuilder sb){
	        if(digitIndex == digits.length()){
	            result.add(sb.toString());
	            return;
	        }
	        for(Character ch : numberLetterMap.get(digits.charAt(digitIndex)).toCharArray()){
	            sb.replace(digitIndex, digitIndex+1, Character.toString(ch));
	            letterUtil(digits, digitIndex+1, sb);
	        }    
	    }
	    private void init(String digits){
	        result = new ArrayList<String>((int) Math.pow(3, digits.length()));
	        numberLetterMap = new HashMap<>(10);
	        numberLetterMap.put('2', "abc");
	        numberLetterMap.put('3', "def");
	        numberLetterMap.put('4', "ghi");
	        numberLetterMap.put('5', "jkl");
	        numberLetterMap.put('6', "mno");
	        numberLetterMap.put('7', "pqrs");
	        numberLetterMap.put('8', "tuv");
	        numberLetterMap.put('9', "wxyz");
	    }
	}
}
