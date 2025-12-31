class Solution {
    private void buildGrid(int[][] cells , int i,int[][] grid){
        for(int x = 0 ; x < i ; ++x){
            grid[cells[x][0]-1][cells[x][1]-1] = 1;
        }
    }
    private boolean isPathExist(int[][] grid){
        int[][] stack = new int[grid.length*grid[0].length][2];
        int tos = -1;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid[0].length ; ++i){
            if(grid[0][i] !=  1){
                stack[++tos] = new int[]{0,i};
                vis[0][i] = true;
            }
        }
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        while(tos != -1){
            int[] u = stack[tos--];
            if(u[0] == grid.length-1)return true;
            for(int[] d:dir){
                int dx = u[0] + d[0] , dy = u[1] + d[1];
                if(dx < 0 || dx >= grid.length || dy < 0 || dy >= grid[0].length || vis[dx][dy] || grid[dx][dy] == 1)continue;
                vis[dx][dy] = true;
                stack[++tos] = new int[]{dx,dy};
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 0 , high = row * col ;
        int res = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            int[][] grid = new int[row][col];
            buildGrid(cells,mid,grid);
            if(isPathExist(grid)){
                res = mid;
                low = mid+1;
                System.out.println("h");
            }else{
                high = mid-1;
            }
        }
        return res;
    }
}