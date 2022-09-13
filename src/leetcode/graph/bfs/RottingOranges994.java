package leetcode.graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges994 {class Solution {
    class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "("+x+","+y+")";
        }
    }
    boolean isValid(int x, int y, int m, int n){
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
    public int orangesRotting(int[][] grid) {
        int [][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
        };
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<Point> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){ //rotten
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }
        int count = 0;
        while(! q.isEmpty() ){
            int size = q.size();
            //System.out.println(q);
            while(size > 0){
                Point p = q.remove();
                for(int[] dir: directions){
                    int px = p.x + dir[0];
                    int py = p.y + dir[1];
                    if(isValid(px, py, m, n) && grid[px][py] == 1 && visited[px][py] == false){
                        grid[px][py] = 2;
                        q.add(new Point(px, py));
                        visited[px][py] = true;
                    }
                }
                size--;
            }
            
            count++;
        }
        if(count != 0 )
            count--;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){ //rotten
                   count = -1;
                }
            }
        }
        
        return count;
    }
}}
