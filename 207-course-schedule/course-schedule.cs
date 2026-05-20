public class Solution {
    private bool Dfs(int node, Dictionary<int, List<int>> adj, bool[] visited, bool[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        if (adj.ContainsKey(node)) {
            foreach (int v in adj[node]) {
                if (!visited[v]) {
                    if (Dfs(v, adj, visited, pathVisited)) return true;
                } else if (pathVisited[v]) {
                    return true;
                }
            }
        }
        pathVisited[node] = false; 
        return false;
    }

    public bool CanFinish(int numCourses, int[][] prerequisites) {
        Dictionary<int, List<int>> adj = new Dictionary<int, List<int>>();
        foreach (int[] p in prerequisites) {
            if (!adj.ContainsKey(p[1])) adj[p[1]] = new List<int>();
            adj[p[1]].Add(p[0]); 
        }

        bool[] visited = new bool[numCourses];
        bool[] pathVisited = new bool[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (Dfs(i, adj, visited, pathVisited)) return false; 
            }
        }
        return true; 
    }
}
