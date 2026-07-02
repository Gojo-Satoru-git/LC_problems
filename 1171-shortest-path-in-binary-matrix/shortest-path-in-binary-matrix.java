class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); 
        int[][] dist = new int[n][n];
        for(int i = 0 ; i < n  ; ++i){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 1;
        pq.offer(new int[]{dist[0][0],0,0});
        int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int c = cell[0];
            for(int[] d:dirs){
                int dx = d[0]  + cell[1];
                int dy = d[1]  + cell[2];
              
                if(dx >= 0 && dx < n && dy >= 0 && dy < n && grid[dx][dy] != 1){
                    //System.out.println(dx +" "+dy+" "+ c );
                    if(c + 1 < dist[dx][dy] ){
                        dist[dx][dy] = c + 1;
                        pq.offer(new int[]{dist[dx][dy],dx,dy});
                    }
                }
            }
        }
        return dist[n-1][n-1] == Integer.MAX_VALUE ? -1 : dist[n-1][n-1];
        
    }
}