package geeksforgeeks.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class TopologicalSorting {
	// No. of vertices
	private int V;

	// Adjacency List as ArrayList of ArrayList's
	private ArrayList<ArrayList<Integer>> adj;

	// Constructor
	TopologicalSorting(int v) {
		V = v;
		adj = new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; ++i)
			adj.add(new ArrayList<Integer>());
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj.get(v).add(w);
	}

	// Driver code
	public static void main(String args[]) {
		// Create a graph given in the above diagram
		TopologicalSorting g = new TopologicalSorting(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		// Function Call
		g.topologicalSort();
	}

	private void topologicalSort() {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[V];
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				topologicalSortUtil(i, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void topologicalSortUtil(int i, boolean[] visited, Deque<Integer> stack) {
		// TODO Auto-generated method stub
		visited[i] = true;
		for (Integer edgeVertex : adj.get(i)) {
			if (visited[edgeVertex] == false) {
				topologicalSortUtil(edgeVertex, visited, stack);
			}
		}
		stack.push(i);
	}

}
