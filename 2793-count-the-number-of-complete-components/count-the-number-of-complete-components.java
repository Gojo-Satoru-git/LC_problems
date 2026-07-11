class Solution {
    boolean[] vis;

    private int[] dfs(int u, List<Integer>[] adj) {
        int numOfNodes = 0, numOfEdges = 0;
        Stack<Integer> st = new Stack<>();
        st.push(u);
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                vis[node] = true;
                ++numOfNodes;
                for (int v : adj[node]) {  
                    ++numOfEdges;          
                    if (!vis[v]) {
                        st.push(v);
                    }
                }
            }
        }
        return new int[]{numOfNodes, numOfEdges / 2};
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        vis = new boolean[n];
        int ct = 0;
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                int[] componentInfo = dfs(i, adj);
                int N = componentInfo[0];
                int E = componentInfo[1];
                System.out.println(N + " " + E);
                if (E == N * (N - 1) / 2) ++ct;  
            }
        }
        return ct;
    }
}
