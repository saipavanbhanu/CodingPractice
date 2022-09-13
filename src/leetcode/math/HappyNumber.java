package leetcode.math;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/happy-number/
public class HappyNumber {
	class Solution {
	    public boolean isHappy(int n) {
	        Set<Integer> set = new HashSet<>();
	        //boolean isHappy = false;
	        do{
	            
	            //calculating the sum of square of digits in number;
	            int temp = n;
	            int sum = 0;
	            while(temp != 0){
	                int digit = temp % 10;
	                sum = sum + (digit * digit);
	                temp = temp / 10;
	            }
	            n = sum;
	            //System.out.println(sum);
	            
	            if(sum == 1){
	                return true;
	            }else{
	                if(set.contains(sum)){
	                    return false;
	                }else{
	                    set.add(sum);
	                }
	            }
	        }while(true);        
	    }
	}
}
