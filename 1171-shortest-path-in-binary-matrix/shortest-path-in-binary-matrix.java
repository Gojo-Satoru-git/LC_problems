class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)return -1;
        Queue<int[]> q = new ArrayDeque<>(); 
        boolean vis[][] =  new boolean[n][n];
        q.offer(new int[]{1,0,0});
        int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        vis[0][0] = true;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int c = cell[0];
            if(cell[1] == n-1 && cell[2] == n-1)return c;
            for(int[] d:dirs){
                int dx = d[0]  + cell[1];
                int dy = d[1]  + cell[2];
                if(dx >= 0 && dx < n && dy >= 0 && dy < n && grid[dx][dy] == 0 && !vis[dx][dy]){
                        vis[dx][dy] = true;
                        q.offer(new int[]{c+1,dx,dy});
                }
            }
        }
        return -1;
        
    }
}