package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
	class Solution {
	    public boolean isValid(String s) {
	        if(s == null || s.length() == 0){
	            return true;
	        }
	        Deque<Character> stack = new LinkedList<>();
	        char ch =' ';
	        for(int i = 0; i < s.length(); i++){
	            ch = s.charAt(i);
	            if(ch == '(' || ch == '{' ||ch == '['){
	                stack.push(ch);
	            }else {
	                if(ch == ')'){
	                    if(stack.isEmpty() == true)
	                        return false;
	                    
	                    char popped = stack.pop();
	                    if(popped == '('){
	                        continue;
	                    }else{
	                        return false;
	                    }
	                }else if(ch == ']'){
	                    if(stack.isEmpty() == true)
	                        return false;
	                    
	                    char popped = stack.pop();
	                    if(popped == '['){
	                        continue;
	                    }else{
	                        return false;
	                    }
	                }else if(ch == '}'){
	                    if(stack.isEmpty() == true)
	                        return false;
	                    
	                    char popped = stack.pop();
	                    if(popped == '{'){
	                        continue;
	                    }else{
	                        return false;
	                    }
	                }else{
	                    return false;
	                }
	            }
	        }
	        if(stack.size() > 0){
	            return false;
	        }
	        return true;
	    }
	}
}
