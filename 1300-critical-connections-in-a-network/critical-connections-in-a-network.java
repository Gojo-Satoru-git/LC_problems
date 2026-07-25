class Solution {
    List<List<Integer>> res;
    int timer = 1;
    private void dfs(int node , int parent ,boolean[] vis,List<Integer>[] adj , int[] tin , int[] low){
        tin[node] = timer;
        low[node] = timer;
        ++timer;
        for(int v:adj[node]){
            if(parent == v)continue;
            if(!vis[v]){
                vis[node] = true;
                dfs(v,node,vis,adj,tin,low);
                low[node] = Math.min(low[node],low[v]);
                if (low[v] > tin[node]) res.add(Arrays.asList(node, v));
            }else{
                low[node] = Math.min(low[node],low[v]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        res = new ArrayList<>();
        int tin[] = new int[n];
        int low[] = new int[n];
        boolean[] vis = new boolean[n];
        List<Integer>[] adj = new ArrayList[n];
        for(int i =  0 ; i < n ; ++i){
            adj[i] = new ArrayList<>();
        }
        Arrays.fill(low,Integer.MAX_VALUE);
        for(List<Integer> con:connections){
            adj[con.get(0)].add(con.get(1));
            adj[con.get(1)].add(con.get(0));
        }
        vis[0] = true;
        dfs(0,-1,vis,adj,tin,low);
        return res;
    }
}