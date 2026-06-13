class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        int[] inDegree = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; ++i){
            adj[i] = new ArrayList<>();
        }
        for(int u = 0 ; u < n ; ++u){
            for(int v:graph[u]){
                adj[v].add(u);
                inDegree[u]++;
            }
        }
        for(int i = 0 ; i < n ; ++i){
            if(inDegree[i] == 0)q.offer(i);
        }
        while(!q.isEmpty()){
            int u = q.poll();
            res.add(u);
            for(int v:adj[u]){
                --inDegree[v];
                if(inDegree[v] == 0)q.offer(v);
            }
        }
        Collections.sort(res);
        return res;

    }
}