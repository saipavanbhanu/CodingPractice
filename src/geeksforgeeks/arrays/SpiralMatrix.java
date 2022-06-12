package geeksforgeeks.arrays;

public class SpiralMatrix {

	public static void main(String[] args) {		
		int a[][] = { 
					{  1,  2, 3,  4 },
					{  5,  6, 7,  8 },
					{  9, 10, 11, 12 },
					{ 13, 14, 15, 16 } };
 
        spiralOrder(a, 4, 4);
        System.out.println();
        int b[][] = { 
				{  1,  2, 3,  4,  17 },
				{  5,  6, 7,  8,  18 },
				{  9, 10, 11, 12, 19 },
				{ 13, 14, 15, 16, 20 } };

        spiralOrder(b, 4, 5);

        
	}

	private static void spiralOrder(int[][] a, final int ROWS, final int COLUMNS) {
		int rowStart = 0, rowEnd = ROWS - 1, colStart = 0, colEnd = COLUMNS - 1;
		
		while(rowStart < rowEnd && colStart < colEnd ) {
			for(int i = colStart; i <= colEnd; i++) {
				System.out.print(a[rowStart][i]+" ");
			}
			rowStart++;
			
			for(int i = rowStart; i <= rowEnd; i++) {
				System.out.print(a[i][colEnd]+" ");
			}
			colEnd--;
			
			
			for(int i = colEnd; i >= colStart; i-- ) {
				System.out.print(a[rowEnd][i]+" ");
			}
			rowEnd--;
			
			for(int i = rowEnd; i >= rowStart; i-- ) {
				System.out.print(a[i][colStart]+" ");
			}
			colStart++;
		}
	}

}
