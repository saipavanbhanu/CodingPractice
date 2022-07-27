package leetcode.tree;

public class RedundantConnection684 {
	class Solution {
		int parent[];
		int rank[];

		public int[] findRedundantConnection(int[][] edges) {
			int n = edges.length;
			parent = new int[n + 1];
			rank = new int[n + 1];
			init();

			for (int[] edge : edges) {
				if (union(edge[0], edge[1]) == false) {
					return edge;
				}
			}
			return new int[] {};
		}

		boolean union(int v1, int v2) {
			int p1 = find(v1);
			int p2 = find(v2);
			if (p1 == p2) {
				return false;
			} else {
				if (rank[p1] > rank[p2]) {
					rank[p1] = rank[p1] + rank[p2];
					parent[p2] = p1;
				} else {
					rank[p2] = rank[p2] + rank[p1];
					parent[p1] = p2;
				}
				return true;
			}

		}

		int find(int vertex) {
			int parentVertex = parent[vertex];
			while (parentVertex != parent[parentVertex]) {
				parentVertex = parent[parentVertex];
			}
			return parentVertex;
		}

		void init() {
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
		}

	}
}
