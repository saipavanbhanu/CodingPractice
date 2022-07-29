package leetcode.heap;

import java.util.PriorityQueue;

public class KClosestPointstoOrigin973 {
	class Solution {
		class Point implements Comparable<Point> {
			double x, y;

			Point(double x, double y) {
				this.x = x;
				this.y = y;
			}

			public int compareTo(Point obj) {
				Double dFromOrigin1 = Math.sqrt(this.x * this.x + this.y * this.y);
				Double dFromOrigin2 = Math.sqrt(obj.x * obj.x + obj.y * obj.y);
				return -dFromOrigin1.compareTo(dFromOrigin2);
				// return (int)( dFromOrigin2 - dFromOrigin1 );
			}

			public String toString() {
				return "(" + x + "," + y + ")";
			}
		}

		public int[][] kClosest(int[][] points, int k) {
			PriorityQueue<Point> pq = new PriorityQueue<>(k + 2);
			if (points == null) {
				return points;
			} else {
				for (int i = 0; i < points.length; i++) {
					if (pq.size() < k) {
						pq.add(new Point(points[i][0], points[i][1]));
					} else {
						pq.add(new Point(points[i][0], points[i][1]));
						pq.poll();
					}
					// System.out.println("pq:"+pq);
				}

				int[][] result = new int[k][2];
				for (int i = 0; i < k; i++) {
					Point p = pq.poll();
					result[i][0] = (int) p.x;
					result[i][1] = (int) p.y;
				}
				return result;
			}
		}
	}
}
