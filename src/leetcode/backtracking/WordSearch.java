package leetcode.backtracking;
//https://leetcode.com/problems/word-search/
public class WordSearch {
	class Solution {
	    char[][] board;
	    int rows, columns;
	    public boolean exist(char[][] board, String word) {
	        if(board == null || word == null ){
	            return false;
	        }
	        this.board = board;
	        rows = board.length;
	        columns = board[0].length;
	        for(int i = 0; i < rows; i++){
	            for(int j = 0; j < columns; j++){
	                if( board[i][j] == word.charAt(0) ){
	                    if(wordExists(i, j, word, 0)){
	                        return true;    
	                    }
	                }
	            }
	        }
	        return false;
	    }
	    boolean wordExists(int i, int j, String word, int index){
	        if(index == word.length()){
	            return true;
	        }
	        if(i < 0 || j < 0 || i > rows - 1 || j > columns - 1 || board[i][j] != word.charAt(index)){
	            return false;
	        }
	        board[i][j]= '*';
	        boolean result = wordExists(i, j-1, word, index + 1) || 
	            wordExists(i-1, j, word, index + 1) || 
	            wordExists(i, j+1, word, index + 1) || 
	            wordExists(i+1, j, word, index + 1);
	        board[i][j] = word.charAt(index);
	        return result; 
	    }
	}
}
