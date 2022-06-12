package geeksforgeeks.arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/a-boolean-matrix-question/
public class BooleanMatrix {

	public static void printMatrix(int mat[][], int R,
			int C)
	{
		int i, j;
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}		
	}

	public static void main(String[] args)
	{
		int mat[][] = {
				{ 1, 0, 0, 1 },
				{ 0, 0, 1, 0 },
				{ 0, 0, 0, 0 },
		};

		System.out.println("Matrix Initially");
		printMatrix(mat, 3, 4);
		modifyMatrix(mat, 3, 4);
		System.out.println("Matrix after modification n");
		printMatrix(mat, 3, 4);
	}

	private static void modifyMatrix(int[][] mat, final int R, final int C) {
		boolean rowFlag = false, colFlag = false;
		
		for(int i = 0; i < R; i++) {
			if(mat[i][0] == 1) {
				colFlag = true;
				break;
			}
		}
		for(int i = 0; i < C; i++) {
			if(mat[0][i] == 1) {
				rowFlag = true;
				break;
			}
		}
		
		for(int i = 1; i < R; i++) {
			for(int j = 1; j < C; j++) {
				if(mat[i][j] == 1) {
					mat[i][0] = 1;
					mat[0][j] = 1;
				}
			}
		}
		
		for(int i = 1; i < R; i++) {
			for(int j = 1; j < C; j++) {
				if(mat[i][0] == 1 || mat[0][j] == 1) {
					mat[i][j] = 1;
				}
			}
		}
		
		if(rowFlag == true) {
			for(int i = 0; i < C; i++) {
				mat[0][i] = 1;
			}
		}
		
		if(colFlag == true) {
			for(int i = 0; i < R; i++) {
				mat[i][0] = 1;
			}
		}
		
	}
	

//	private static void modifyMatrix(int[][] mat, int R, int C) {
//		int []row = new int[R];
//		int []column = new int[C];
//		System.out.println("row: "+Arrays.toString(row));
//		int i,j;
//		for(i = 0; i < R; i++) {
//			for(j = 0; j < C; j++) {
//				if(mat[i][j] == 1) {
//					row[i] = 1;
//					column[j] = 1;
//				}
//			}
//		}
//		for(i = 0; i < R; i++) {
//			for(j = 0; j < C; j++) {
//				if( row[i] == 1 || column[j] == 1) {
//					mat[i][j] = 1;
//				}
//			}
//		}
//	}
// Time complexity = O(RC); space complexity = O(R+C)
	
	
}
