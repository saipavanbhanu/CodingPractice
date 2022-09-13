package leetcode.graph.topologicalSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleII210 {class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //List<Integer>[] graph=new ArrayList[numCourses];
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adjList.add(i, new LinkedList<Integer>());
        }
        
        for(int[] pre : prerequisites){
            List<Integer> preList = adjList.get(pre[0]);
            // if(adjList.get(pre[0]) == null){
            //     preList = new LinkedList<Integer>();
            // }
            preList.add(pre[1]);
        }
        
        Boolean[] arr = new Boolean[numCourses];
        Arrays.fill(arr, false);
        List<Boolean> visited = Arrays.asList(arr);
        List<Integer> output = new ArrayList<>(numCourses);
        
        Boolean[] cycleArr = new Boolean[numCourses];
        Arrays.fill(cycleArr, false);
        List<Boolean> cycle = Arrays.asList(cycleArr);
        
        for(int i = 0; i < numCourses; i++){
            if(visited.get(i) == false){
                if( dfs(i, visited, output, adjList, cycle) == false ){
                    //cycle
                    return new int[0];
                }
            }
        }
        
        return output.stream().mapToInt(Integer::intValue).toArray();
    }
    
    boolean dfs(int course, List<Boolean> visited, List<Integer> output, List<List<Integer>> adjList, List<Boolean> cycle){
        
        if(cycle.get(course) == true){
            return false;
        }
        if(visited.get(course) == true){
            return true;
        }
        
        cycle.set(course,true);
        for(int pre : adjList.get(course)){
            if(dfs(pre, visited, output, adjList, cycle) == false){
                return false;
            }
        }
        cycle.set(course,false);
        visited.set(course, true);
        output.add(course);
        return true;
    }
    
}}
