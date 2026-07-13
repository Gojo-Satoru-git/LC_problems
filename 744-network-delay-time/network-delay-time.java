class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        List<int[]>[] adj = new ArrayList[n+1];
        for(int i = 0 ;i <= n ; ++i){
            adj[i] = new ArrayList<>();
        }
        for(int[] t:times){
            adj[t[0]].add(new int[]{t[1],t[2]});
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0] - b[0]));
        dist[k] = 0;
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0];
            int c = node[1];
            for(int[] v:adj[u]){
                if(v[1] + c < dist[v[0]]){
                    dist[v[0]] = v[1] + c;
                    pq.offer(new int[]{v[0],dist[v[0]]});
                }
            }
        }
        int res = 0;
        for(int i = 1 ; i <= n ; ++i){
            int c = dist[i];
            if(c == Integer.MAX_VALUE)return -1;
            res = Math.max(c,res);
        }
        return res;
    }
}