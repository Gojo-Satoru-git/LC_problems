class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[0] - b[0] != 0 ? a[0] - b[0] : a[2] - b[2]; 
        });
        int[] dist = new int[n];
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n  ; ++i){
            adj[i] = new ArrayList<>();
        }
        for(int[] f:flights){
            adj[f[0]].add(new int[]{f[1],f[2]});
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]  = 0;
        pq.offer(new int[]{0,src,0});
        while(!pq.isEmpty()){
            int[] u = pq.poll();
            int c = u[2];
            int steps = u[0];
            //if(u[1] == dst)return c;
            if(steps > k)continue;
            for(int[] v:adj[u[1]]){
                if(c + v[1] < dist[v[0]]){
                    dist[v[0]] = v[1]+c;
                    pq.offer(new int[]{steps+1,v[0],dist[v[0]]});
                }
            }
        }
        return dist[dst] != Integer.MAX_VALUE ? dist[dst] : -1;
    }
}