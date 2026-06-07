class Solution {
    private void dfs(int i,int[][] graph,int[] vis){
        Stack<Integer> st = new Stack<>();
        st.push(i);
        vis[i] = 0;
        while(!st.isEmpty()){
            int u = st.pop();
            for(int v:graph[u]){
                if(vis[v] == -1){
                    vis[v] = vis[u] == 0 ? 1 : 0;
                    st.push(v);
                }
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length ;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == -1){
                dfs(i,graph,vis);
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