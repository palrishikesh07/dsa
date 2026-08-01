//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Graph {

    public static void main(String[] args) {
        
    }

    
    
}

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> result = new ArrayList<>();

        int v = adj.size();

        boolean[] visited = new boolean[v];

        Queue<Integer> queue = new LinkedList<>();


        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            // Remove front node
            
            int current = queue.poll();

            result.add(current);


            for(int neighbour : adj.get(current)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        return result;
        
    }
}
