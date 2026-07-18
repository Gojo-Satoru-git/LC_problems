class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0 ; i < n ; ++i){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for(int[] edge:edges){
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for(int k = 0 ; k < n ; ++k){
            for(int i = 0 ; i < n ; ++i ){
                for(int j = 0; j < n ; ++j){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int smallestNumber = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0 ; i < n ; ++i){
            int cnt = 0;
            for(int j = 0 ; j < n ; ++j){
                if(dist[i][j] <= distanceThreshold){
                    ++cnt;
                }
            }
            if(cnt < smallestNumber){
                smallestNumber = cnt;
                res = i;
            }else if(cnt == smallestNumber){
                res = Math.max(i,res);
            }
        }
        return res;
    }
}