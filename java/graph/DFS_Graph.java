// https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_Graph {

    public static void main(String[] args) {

    }

}

class Solution {

    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
            visited[node] = true;

            result.add(node);

            for(int neighbour: adj.get(node)){
                    
                if(!visited[neighbour]){
                    dfsHelper(node, adj, visited, result);
                }
            }
    }

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];

        dfsHelper(0, adj, visited, result);

        return result;
    }
}
