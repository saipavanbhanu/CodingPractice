package leetcode.dp;

public class LongestPalindromicSubstring {
	class Solution {
	    public String longestPalindrome(String s) {
	        int n = s.length();
	        boolean dp[][] = new boolean[n][n];
	        if(s.length() == 1){
	            return s;
	        }
	        
	        int start = -1, maxLength = -1;
	        
	        //for a string of length 1, it is always a palindrome
	        for(int i = 0; i < n; i++){
	            dp[i][i] = true;
	            start = i;
	            maxLength = 1;
	        }
	        
	        //for a string of length 2, we can check whether first and last are equal, if so they are palindrome
	        for(int i = 0; i < n-1; i++){
	            if(s.charAt(i) == s.charAt(i+1)){
	                dp[i][i+1] = true;
	                start = i;
	                maxLength = 2;
	            }
	        }
	        
	        //recursive relation for a string of length 3
	        for(int k = 3; k <= n; k++){
	            for(int i = 0; i < n-k+1; i++){
	                int j = i + k - 1;
	                //System.out.println("chars "+s.charAt(i) +" "+ s.charAt(j));
	                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
	                    dp[i][j] = true;
	                    //System.out.println("outside "+start+" "+maxLength);
	                    if(k > maxLength){
	                        //System.out.println("inside "+start+" "+maxLength);
	                        maxLength = k;
	                        start = i;
	                    }
	                    
	                }
	            }
	        }
	        
	        //System.out.print(start+" "+maxLength);
	        return s.substring(start, start + maxLength);
	        
	    }
	}
}
