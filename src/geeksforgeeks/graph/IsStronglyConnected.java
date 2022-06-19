package geeksforgeeks.graph;

import java.util.LinkedList;

public class IsStronglyConnected {
	private final int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List

	// Constructor
	IsStronglyConnected(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	private void DfsUtil(int vertex, boolean[] visited, LinkedList<Integer> adj[]) {
		visited[vertex] = true;
		for (Integer edgeVertex : adj[vertex]) {
			if (!visited[edgeVertex]) {
				DfsUtil(edgeVertex, visited, adj);
			}
		}
	}

	private boolean isSC() {
		boolean visited[] = new boolean[V];
		DfsUtil(0, visited, adj);

		// check if all the vertices are visited from any arbitrary vertex;
		for (int i = 0; i < V; i++) {
			if (visited[i] == false)
				return false;
		}

		// create a graph transpose
		LinkedList<Integer> adjT[] = createGraphTranspose();
		visited = new boolean[V];
		DfsUtil(0, visited, adjT);

		// check if all the vertices are visited from any arbitrary vertex;
		for (int i = 0; i < V; i++) {
			if (visited[i] == false)
				return false;
		}

		return true;
	}

	private LinkedList<Integer>[] createGraphTranspose() {
		IsStronglyConnected graphT = new IsStronglyConnected(V);
		for (int i = 0; i < V; i++) {
			for (Integer edgeVertex : adj[i]) {
				graphT.adj[edgeVertex].add(i);
			}
		}
		return graphT.adj;
	}

	public static void main(String args[]) {
		// Create graphs given in the above diagrams
		IsStronglyConnected g1 = new IsStronglyConnected(5);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(2, 3);
		g1.addEdge(3, 0);
		g1.addEdge(2, 4);
		g1.addEdge(4, 2);
		if (g1.isSC())
			System.out.println("Yes");
		else
			System.out.println("No");

		IsStronglyConnected g2 = new IsStronglyConnected(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		if (g2.isSC())
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
