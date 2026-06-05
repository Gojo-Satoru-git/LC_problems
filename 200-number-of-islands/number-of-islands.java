class Solution {
    private void dfs(int i , int j , char[][] grid , boolean[][] vis){
        vis[i][j] = true;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d:dir){
            int dx = i + d[0];
            int dy = j + d[1];
            if(dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && !vis[dx][dy] && grid[dx][dy] != '0'){
                dfs(dx,dy,grid,vis);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length ; 
        int n = grid[0].length ;
        boolean[][] visited = new boolean[m][n];
        int numOfIslands = 0;
        for(int i =0 ; i <  m ; ++i){
            for(int j = 0 ; j < n ; ++j){
                if(grid[i][j] == '1' && !visited[i][j]){
                    ++numOfIslands;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return numOfIslands; 
    }
}