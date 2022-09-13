package geeksforgeeks.graph;

//knight walk problem is also similar to this
//instead of recursion we can store that in a state and add them in the queue => until we found out that solution.

public class MinStepsToReachDestination {

	private static int steps(int source, int step, int destination) {

		if (Math.abs(source) > destination) {
			return Integer.MAX_VALUE;
		}
		if(source == destination) {
			
			return step;
		}
		
		int pos = steps(source + (step + 1), step + 1, destination);
		int neg = steps(source - (step + 1), step + 1, destination);

		return Math.min(pos, neg);
	}

	// Driver Code
	public static void main(String[] args) {
		int dest = 3;
		System.out.println("No. of steps required" + " to reach " + dest + " is " + steps(0, 0, dest));
	}

}
