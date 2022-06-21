package geeksforgeeks.graph;

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class CycleInDirectedGraph {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();

     while (t-- > 0) {
         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
         int V = sc.nextInt();
         int E = sc.nextInt();
         for (int i = 0; i < V + 1; i++)
             list.add(i, new ArrayList<Integer>());
         for (int i = 0; i < E; i++) {
             int u = sc.nextInt();
             int v = sc.nextInt();
             list.get(u).add(v);
         }
         if (new Solution6().isCyclic(V, list) == true)
             System.out.println("1");
         else
             System.out.println("0");
     }
 }
}// } Driver Code Ends


/*Complete the function below*/

class Solution6 {
 private boolean isCyclicUtil(int vertex, ArrayList<ArrayList<Integer>> adj, 
 boolean[] visited, boolean[] stack){
     
     visited[vertex] = true;
     stack[vertex] = true;
     
     for(Integer edgeVertex : adj.get(vertex)){
         if(visited[edgeVertex] == false){
             if(isCyclicUtil(edgeVertex, adj, visited, stack)){
                 return true;
             }
         }else{
             if(stack[edgeVertex] == true){
                 return true;
             }else{
            	 //stack[vertex] = false;
                 //return false;
             }
         }
     }
     
     stack[vertex] = false;
     return false;
 }
 
 // Function to detect cycle in a directed graph.
 public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
     // code here
     boolean visited[] = new boolean[V];
     boolean stack[] = new boolean[V];
     
     for(int i = 0; i < V; i++){
         if(!visited[i]){
             if( isCyclicUtil(i, adj, visited, stack)){
            	 //System.out.println("i:"+i+"\nst: "+Arrays.toString(stack)+"\nvt: "+Arrays.toString(visited));
                 return true;
             }
         }
     }
     return false;
 }
}