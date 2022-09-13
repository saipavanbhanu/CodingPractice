//  Driver Code Starts
//Initial Template for Java
package geeksforgeeks.graph;
//calculation of no of strongly connected components in the graph.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class StronglyConnectedComponents
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution2 ob = new Solution2();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution2
{
    
    private Deque<Integer> fillStack(int V, ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[V];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                fillStackUtil(i, adj, visited, stack);
                //System.out.println("Stack for "+i+stack);
            }
        }
        return stack;
    }
    private void fillStackUtil(int i, ArrayList<ArrayList<Integer>> adj,
    boolean []visited, Deque<Integer> stack){
        visited[i] = true;
        for(Integer adjVertex : adj.get(i) ){
             if(!visited[adjVertex]){
                fillStackUtil(adjVertex, adj, visited, stack);
            }           
        }
        stack.push(i);
    }
    
    private ArrayList<ArrayList<Integer>> graphTranspose(ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>(adj.size());
        
        for(int i = 0; i < adj.size(); i++) {
        	adjT.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < adj.size(); i++){
            Integer vertex = i;
        //for(Integer vertex : adj ){
            ArrayList<Integer> edgeList = adj.get(vertex);
            for(Integer edge : edgeList){
                if(adjT.get(edge) == null ){
                    adjT.add(edge, new ArrayList<Integer>(adj.size() * 2));
                }
                adjT.get(edge).add(Integer.valueOf(vertex));
            }
        }
        return adjT;
    }
    
    private void DFSUtil(int vertex, ArrayList<ArrayList<Integer>> adj, boolean []visited){
        visited[vertex]=true;
        for(Integer adjVertex : adj.get(vertex)){
            if(!visited[adjVertex]){
                DFSUtil(adjVertex, adj, visited);
            }
        }
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Deque<Integer> stack = fillStack(V, adj); 
        //System.out.println("stack"+stack);
        ArrayList<ArrayList<Integer>> adjT = graphTranspose(adj);
        int count = 0;
        boolean visited[] = new boolean[V];
        
        while(!stack.isEmpty()){
        	Integer i = stack.pop();
        	if(!visited[i]) {
        		DFSUtil(i, adjT, visited);
        		//System.out.println("popped: "+i+" visited: "+Arrays.toString(visited));
        		count++;
        	}
        }
        return count;
    }
}
