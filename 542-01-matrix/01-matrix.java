class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int[] d : dir){
                int r = cell[0] + d[0], c = cell[1] + d[1];
                if(r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]){
                    res[r][c] = res[cell[0]][cell[1]] + 1;
                    visited[r][c] = true;
                    q.offer(new int[]{r,c});
                }
            }
        }
        
        return res;
    }
}
