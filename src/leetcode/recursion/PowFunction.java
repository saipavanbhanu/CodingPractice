package leetcode.recursion;

public class PowFunction {
	class Solution {
	    public double myPow(double x, int n) {
	        double result = myPowUtil(x,Math.abs(n));
	        if(n < 0){
	            return 1/result;
	        }
	        return result;
	    }
	    public double myPowUtil(double x, int n){
	        if(n == 0)
	            return 1;
	        if(n % 2 == 0){
	            double half = myPowUtil(x, n/2);
	            return half * half;
	        }else{
	            double half = myPowUtil(x,n/2);
	            return half * half * x;
	        }        
	    }
	}
}
