package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	class Solution {
	    List<Integer> result;
	    public List<Integer> spiralOrder(int[][] matrix) {
	        if(matrix == null){
	            return null;
	        }
	        int rows = matrix.length;
	        int columns = matrix[0].length;
	        result = new ArrayList<>(rows * columns);
	        spiralOrder(matrix, rows, columns);
	        return result;
	    }
	    private void spiralOrder(int[][] a, final int ROWS, final int COLUMNS) {
			int rowStart = 0, rowEnd = ROWS - 1, colStart = 0, colEnd = COLUMNS - 1;
			
			while(rowStart <= rowEnd && colStart <= colEnd ) {
				for(int i = colStart; i <= colEnd; i++) {
	                result.add(a[rowStart][i]);
//					System.out.print(a[rowStart][i]+" ");
				}
				rowStart++;
				
				for(int i = rowStart; i <= rowEnd; i++) {
	                result.add(a[i][colEnd]);
//	                System.out.print(a[i][colEnd]+" ");
				}
				colEnd--;
				
				if(rowStart <= rowEnd){
	                for(int i = colEnd; i >= colStart; i-- ) {
	                    result.add(a[rowEnd][i]);
				    }    
	            }
				rowEnd--;
				
				if(colStart <= colEnd){
	                for(int i = rowEnd; i >= rowStart; i-- ) {
	                    result.add(a[i][colStart]);
	                }
	            }
				colStart++;
			}
	       
	    }
	}
}
