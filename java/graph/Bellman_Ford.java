//https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

import java.util.Arrays;

public class Bellman_Ford {
    public static void main(String[] args) {
        
    }
}


class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e8);

        distance[src] = 0;

        
        for(int i=1; i<= V-1; i++){
            for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(distance[u] != (int)1e8 && distance[u] + wt < distance[v]){
                    distance[v] = distance[u] + wt;
                }
            }
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(distance[u] != (int)1e8 && distance[u] + wt < distance[v]){
                return new int[]{-1};
            }

        }
        return distance;

    }
}
