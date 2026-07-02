class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0] - a[0]));
        int m = grid.size() , n  = grid.get(0).size();
        int[][] hp = new int[m][n];
        for(int i = 0; i < m ;++i){
            Arrays.fill(hp[i],-1);
        }
        pq.offer(new int[]{health-grid.get(0).get(0),0,0});
        int[][] dirs  = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            for(int[] d:dirs){      
                int h = cell[0];
                int dx = d[0] + cell[1];
                int dy = d[1] + cell[2];
                if(dx >= 0 && dx < m && dy >= 0 && dy < n){
                    int dh = h - grid.get(dx).get(dy);
                    if(dh > hp[dx][dy]){
                        hp[dx][dy] = dh;
                        pq.offer(new int[]{dh,dx,dy});
                    }
                    
                }

            }   
        }
        //System.out.println(hp[m-1][n-1]);
        return hp[m-1][n-1] >= 1;
    }
}