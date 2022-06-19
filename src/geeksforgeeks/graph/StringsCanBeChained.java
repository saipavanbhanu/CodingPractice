package geeksforgeeks.graph;

import java.util.ArrayList;
import java.util.List;

public class StringsCanBeChained {

	static final int CHARS = 26;

	// No. of vertices
	int V;

	// A dynamic array of adjacency lists
	List<List<Integer>> adj;
	int[] in;

	// Constructor
	StringsCanBeChained(int V) {
		this.V = V;
		in = new int[V];
		adj = new ArrayList<>(CHARS);

		for (int i = 0; i < CHARS; i++) {
			adj.add(i, new ArrayList<>());
		}
	}

	// Function to add an edge to graph
	void addEdge(int v, int w) {
		adj.get(v).add(w);
		in[w]++;
	}

	// Method to check if this graph
	// is Eulerian or not
	boolean isEulerianCycle() {

		// Check if all non-zero degree
		// vertices are connected
		if (!isSC())
			return false;

		// Check if in degree and out
		// degree of every vertex is same
		for (int i = 0; i < V; i++)
			if (adj.get(i).size() != in[i])
				return false;

		return true;
	}

	// Function to do DFS starting from v.
	// Used in isConnected();
	// A recursive function to do DFS
	// starting from v
	void DFSUtil(int v, boolean[] visited) {

		// Mark the current node as
		// visited and print it
		visited[v] = true;

		// Recur for all the vertices
		// adjacent to this vertex
		for (Integer i : adj.get(v))
			if (!visited[i]) {
				DFSUtil(i, visited);
			}
	}

	boolean isSC() {

		// Mark all the vertices as not
		// visited (For first DFS)
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Find the first vertex with
		// non-zero degree
		int n;
		for (n = 0; n < V; n++)
			if (adj.get(n).size() > 0)
				break;

		// Do DFS traversal starting from
		// first non zero degree vertex.
		DFSUtil(n, visited);

		// If DFS traversal doesn't visit all
		// vertices, then return false.
		for (int i = 0; i < V; i++)
			if (adj.get(i).size() > 0 && !visited[i])
				return false;

		// Create a reversed graph
		StringsCanBeChained gr = getTranspose();

		// Mark all the vertices as not
		// visited (For second DFS)
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Do DFS for reversed graph starting
		// from first vertex. Starting Vertex
		// must be same starting point of first DFS
		gr.DFSUtil(n, visited);

		// If all vertices are not visited in
		// second DFS, then return false
		for (int i = 0; i < V; i++)
			if (adj.get(i).size() > 0 && !visited[i])
				return false;

		return true;
	}

	// Function that returns reverse
	// (or transpose) of this graph
	// This function is needed in isSC()
	StringsCanBeChained getTranspose() {
		StringsCanBeChained g = new StringsCanBeChained(V);
		for (int v = 0; v < V; v++) {

			// Recur for all the vertices
			// adjacent to this vertex
			for (Integer i : adj.get(v)) {
				g.adj.get(i).add(v);
				g.in[v]++;
			}
		}
		return g;
	}

	// This function takes an of strings
	// and returns true if the given array
	// of strings can be chained to form cycle
	static boolean canBeChained(String[] arr, int n) {

		// Create a graph with 'alpha' edges
		StringsCanBeChained g = new StringsCanBeChained(CHARS);

		// Create an edge from first character
		// to last character of every string
		for (int i = 0; i < n; i++) {
			String s = arr[i];
			g.addEdge(s.charAt(0) - 'a', s.charAt(s.length() - 1) - 'a');
		}

		// The given array of strings can be
		// chained if there is an eulerian
		// cycle in the created graph
		return g.isEulerianCycle();
	}

	public static void main(String[] args) throws Exception {
		String[] arr1 = { "for", "geek", "rig", "kaf" };
		int n1 = arr1.length;

		System.out.println((canBeChained(arr1, n1) ? "Can be chained " : "Can't be chained "));

		String[] arr2 = { "aab", "abb" };
		int n2 = arr2.length;

		System.out.println((canBeChained(arr2, n2) ? "Can be chained " : "Can't be chained "));
	}
}
