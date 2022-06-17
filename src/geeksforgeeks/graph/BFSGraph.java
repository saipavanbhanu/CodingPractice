package geeksforgeeks.graph;

import java.util.LinkedList;
import java.util.Queue;

//constraint here is if all the vertices are reachable from the given vertex;

public class BFSGraph {

	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	BFSGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// Driver method to
	public static void main(String args[]) {
		BFSGraph g = new BFSGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}

	private void BFS(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[V];

		visited[i] = true;
		queue.add(i);

		while (!queue.isEmpty()) {
			int poppedElement = queue.poll();
			visited[poppedElement] = true;
			System.out.print(poppedElement + " ");
			for (Integer element : adj[poppedElement]) {
				if (visited[element] != true) {
					queue.add(element);
				}
			}
		}

	}
}
