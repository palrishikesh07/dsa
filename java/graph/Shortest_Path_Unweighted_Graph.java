//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
public class Shortest_Path_Unweighted_Graph {
    
}



/*

      List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] dist  = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        dist[src] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            int currDist = dist[curr];
            
            if (curr == dest) {
                return dist[dest];
            }

            for (int neighbor : graph.get(curr)) {
                int nextDist = currDist + 1;
                if (dist[neighbor] > nextDist) {
                    dist[neighbor] = currDist + 1;
                    q.add(neighbor);
                }
            }
        }

        return -1;

*/