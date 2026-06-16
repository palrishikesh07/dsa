package java.random_question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Need to in future
public class Graph_Connectivity {
    public static void main(String[] args) {

    }

    public static boolean isSingleNetwork(int n, int[][] referrals) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : referrals) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int start = 0; start < n; start++) {

            boolean[] visited = new boolean[n];

            dfs(start, graph, visited);

            for (boolean nodeVisited : visited) {
                if (!nodeVisited) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void dfs(
            int node,
            List<List<Integer>> graph,
            boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static boolean isSingleNetworkOptimal(int n, int[][] referrals) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : referrals) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        int count = 1;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int neighbor : graph.get(current)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }

        return count == n;
    }
}
