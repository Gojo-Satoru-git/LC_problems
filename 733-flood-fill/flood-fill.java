class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sp = image[sr][sc] ;
        Queue<int[]> q = new ArrayDeque<>();
        image[sr][sc] = color;
        q.offer(new int[]{sr,sc});
        int m = image.length;
        int n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] u = q.poll();
            vis[u[0]][u[1]] = true;
            for(int[] d:dir){   
                int dx = u[0] + d[0] , dy = u[1] + d[1];
                if(dx >= 0 && dx < m && dy >= 0 && dy < n && !vis[dx][dy] && image[dx][dy] == sp){
                    image[dx][dy] = color;
                    vis[dx][dy] = true;
                    q.offer(new int[]{dx,dy});
                }
            }
        }
        return image;
    }
}