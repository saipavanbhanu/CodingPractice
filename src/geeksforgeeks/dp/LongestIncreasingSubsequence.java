package geeksforgeeks.dp;

public class LongestIncreasingSubsequence {

	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis(arr, n) + "\n");
	}

	private static Integer lis(int[] arr, int n) {
		int lis[] = new int[n];
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			int maxBeforeI = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && maxBeforeI <= lis[j]) {
					maxBeforeI = 1 + lis[j];
				}
			}
			lis[i] = maxBeforeI;
		}
		
		int max = lis[0];
		for(int i = 1; i < n; i++){
		    if(max < lis[i])
		        max = lis[i];
		}

        return max;	
	}
}
