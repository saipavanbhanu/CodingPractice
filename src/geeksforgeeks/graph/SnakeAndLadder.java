package geeksforgeeks.graph;

//{ Driver Code Starts
//Initial Template for Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class SnakeAndLadder {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int N = Integer.parseInt(in.readLine());
			String a[] = in.readLine().trim().split("\\s+");
			int arr[] = new int[2 * N];
			for (int i = 0; i < 2 * N; i++)
				arr[i] = Integer.parseInt(a[i]);

			Solution3 ob = new Solution3();
			System.out.println(ob.minThrow(N, arr));
		}
	}
}// } Driver Code Ends

//User function Template for Java

class Solution3 {
	static class QNode {
		int vertex;
		int distance;

		QNode(int v, int d) {
			vertex = v;
			distance = d;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "(" + Integer.toString(vertex) + " " + Integer.toString(distance) + ")";
		}
	}

	static int minThrow(int N, int arr[]) {
		// code here
		int minSteps = Integer.MAX_VALUE;
		boolean visited[] = new boolean[30];
		Queue<QNode> queue = new LinkedList<>();
		QNode first = new QNode(1, 0);
		queue.add(first);

		while (!queue.isEmpty()) {
			QNode polledNode = queue.poll();
			visited[polledNode.vertex - 1] = true;
			int currentIndex = polledNode.vertex;
			//System.out.println(polledNode);

			if (currentIndex == 30) {
				minSteps = polledNode.distance;
				break;
			}

			for (int times = 1; times <= 6 && times + currentIndex <= 30; times++) {
				int i = times + currentIndex;
				boolean isSnakeOrLadder = false;
				// getting destination index;
				int j;
				for (j = 0; j < 2 * N;) {
					if (arr[j] == i) {
						isSnakeOrLadder = true;
						break;
					}
					j = j + 2;
				}
				if (isSnakeOrLadder && visited[arr[j + 1] - 1] == false) {
					QNode node = new QNode(arr[j + 1], polledNode.distance + 1);
					queue.add(node);
					visited[arr[j + 1] - 1] = true;
				} else if (visited[i - 1] == false) {
					QNode node = new QNode(i, polledNode.distance + 1);
					queue.add(node);
					visited[i - 1] = true;
				}

			}
		}

		return minSteps;

	}
}