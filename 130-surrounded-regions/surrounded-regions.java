class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new ArrayDeque<>();
        int m = board.length  , n = board[0].length;
        boolean[][] vis = new boolean[m][n];        
        for(int i = 0 ; i < m ; ++i){
            if(board[i][0] == 'O'){
                q.offer(new int[]{i,0});
                vis[i][0] = true;
            }
            if(board[i][n-1] == 'O'){
                q.offer(new int[]{i,n-1});
                vis[i][n-1] = true;
            }
        }
        for(int i = 1 ; i < n - 1 ; ++i){
            if(board[0][i] == 'O'){
                q.offer(new int[]{0,i});
                vis[0][i] = true;
            }
            if(board[m-1][i] == 'O'){
                q.offer(new int[]{m-1,i});
                vis[m-1][i] = true;
            }
        }
        
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] c = q.poll();
            for(int[] d:dir){
                int dx = c[0] + d[0] , dy = c[1] + d[1];
                if(dx >= 1 && dx < m - 1 && dy >= 1 && dy < n -1 && board[dx][dy] == 'O' && !vis[dx][dy]){
                    vis[dx][dy] = true;
                    q.offer(new int[]{dx,dy});
                }
            }
        }
        for(int i  = 1; i < m - 1 ; ++i){
            for(int j = 1 ; j < n - 1 ; ++j){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}