class Solution {
    private void dfs(int i,int[][] graph,int[] vis,int[] stack){
        int tos = -1;
        stack[++tos] = i;
        vis[i] = 0;
        while(tos != -1){
            int u = stack[tos--];
            for(int v:graph[u]){
                if(vis[v] == -1){
                    vis[v] = vis[u] == 0 ? 1 : 0;
                    stack[++tos] = v;
                }
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length ;
        int[] vis = new int[n];
        int[] stack = new int[n];
        Arrays.fill(vis,-1);
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == -1){
                dfs(i,graph,vis,stack);
            }
        }
        //System.out.println(Arrays.toString(vis));
        for(int i = 0; i < n ; ++i){
            for(int v:graph[i]){
                if(vis[i] == vis[v])return false;
            }
        }
        return true;
    }
}