class Solution {
    private void dfs(int i , int j , int[][] grid , boolean[][] vis){
        vis[i][j]  = true;
        int[][] dir = {{0,1},{0,-1}, {1,0},{-1,0}};
        int m = grid.length , n = grid[0].length;
        for(int[] d: dir){
            int dx = i + d[0] , dy = j + d[1];
            if(dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] == 1 && !vis[dx][dy]){
                dfs(dx,dy,grid,vis);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        boolean[][] vis = new boolean[m][n];    
        for(int i = 0 ; i < m ; ++i){
            if(grid[i][0] == 1){
                dfs(i,0,grid,vis);
            }
            if(grid[i][n-1] == 1){
                dfs(i,n-1,grid,vis);
            }
        }
        for(int i = 1 ; i < n - 1 ; ++i){
            if(grid[0][i] == 1){
                dfs(0,i,grid,vis);
            }
            if(grid[m-1][i] == 1){
                dfs(m-1,i,grid,vis);
            }
        }
        int res = 0;
        for(int i = 1 ; i <  m - 1 ; ++i){
            for(int j = 1 ; j < n - 1 ; ++j){
                if(grid[i][j] == 1 && !vis[i][j])++res;
            }
        }
        return res;
    }
}