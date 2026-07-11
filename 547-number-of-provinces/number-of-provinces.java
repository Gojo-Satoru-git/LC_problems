class Solution {
    boolean[] vis ;
    private void dfs(int u,List<Integer>[] adj){
        vis[u] = true;
        for(int v:adj[u]){
            if(!vis[v]){
                vis[v] = true;
                dfs(v,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0 ;i < n ; ++i ){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < n ; ++j){
                if(i != j && isConnected[i][j] == 1){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        vis = new boolean[n];
        int ct = 0;
        for(int i = 0; i < n ; ++i){
            if(!vis[i]){
                ++ct;
                dfs(i,adj);
            }
        }
        return ct;


    }
}