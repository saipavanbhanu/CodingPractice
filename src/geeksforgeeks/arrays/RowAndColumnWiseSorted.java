package geeksforgeeks.arrays;

//https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/

public class RowAndColumnWiseSorted {

	public static void main(String[] args)
	{
		int mat[][] = { { 10, 20, 30, 40 },
						{ 15, 25, 35, 45 },
						{ 27, 29, 37, 48 },
						{ 32, 33, 39, 50 } };

		search(mat, 4, 51);
	}

	private static void search(int[][] mat, int R, int x) {
		// TODO Auto-generated method stub
		int C = R, i = 0, j = C - 1;
		while(i < R && j >= 0 ) {
			if(mat[i][j] == x) {
				System.out.println("element found at ("+i+","+j+"):"+x);
				return;
			}else if( mat[i][j] > x)
				j--;
			else
				i++;
		}
		System.out.println("element not found");
	}
	

}
