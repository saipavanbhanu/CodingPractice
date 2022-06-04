package geeksforgeeks.hashing;

//https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/

public class LengthOfTheLongestSubstring {
	public static void main(String[] args) {
		
		Solution obj = new Solution();
		System.out.println(obj.longestUniqueSubsttr("abcdhcbayr"));
		
	}
}


class Solution{
    int longestUniqueSubsttr(String s){
    	int max = -1;
    	for(int i = 0; i < s.length()-1; i++) {
    		boolean visited[] = new boolean[256];
    		for(int j = i; j < s.length(); j++) {
    			if(visited[s.charAt(j)] == true) {
    				break;
    			}else {
    				visited[s.charAt(j)] = true;
    				max = Math.max(max, j - i + 1);
    			}
    			
    		}
    	}
    	return max;
    }
}