public class Find_Path_Exists {
    
}




// C++
class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        
        vector<vector<int>> graph(n);
        for(auto &edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }

        queue<int> q;
        vector<int> visited(n,0);
        visited[source] = 1;
        q.push(source);

        while(!q.empty()) {

            int current_node = q.front();
            q.pop();

            if(current_node == destination) {
                return true;
            }

            for(int neighbour : graph[current_node]) {
                if(visited[neighbour] == 0) {
                    visited[neighbour] = 1;
                    q.push(neighbour);
                }
            }
        }
        return false;
    }
};