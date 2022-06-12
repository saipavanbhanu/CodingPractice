package geeksforgeeks.searching;

public class LeftAndRightMostIndex {

	
	
	
	public static void main(String[] args)
	{
		int arr[] = { 1, 2, 2, 2, 2, 3, 8, 8, 8, 8 };
		int x = 8;
		//binarySearch(arr,x);
		findFirstAndLast(arr, x);
	}

	private static void binarySearch(int[] arr, int x) {
		int low = 0, high = arr.length-1, mid;
		mid = ( low + high )/2;
		
		while (low <= high) {
			if(arr[mid] ==  x) {
				System.out.println("element found at "+mid+" element="+x);
				break;
			}else if(arr[mid] < x) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
			mid = (low + high)/2;
		}
		if(low < 0 || high > arr.length-1) {
			System.out.println("element not found");
		}
	}

	private static void findFirstAndLast(int[] arr, int x) {
		findFirst(arr,x);
		findLast(arr,x);
	}

	private static void findLast(int[] arr, int x) {
		// TODO Auto-generated method stub
		
	}

	private static void findFirst(int[] arr, int x) {
		int low = 0, high = arr.length-1, mid;
		mid = ( low + high )/2;
		int firstIndex = -1;
		while (low <= high) {
			if(arr[mid] ==  x) {
				firstIndex = mid;
				high = mid - 1;
			}else if(arr[mid] < x) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
			mid = (low + high)/2;
		}
		if(firstIndex != -1) {
			System.out.println("first index: "+firstIndex);
		}
	}

	
}
