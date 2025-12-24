class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sp = image[sr][sc] ;
        int[][] stack = new int[2500][];
        int tos = -1;
        image[sr][sc] = color;
        stack[++tos] = new int[]{sr,sc};
        int m = image.length;
        int n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        while(tos != -1){
            int[] u = stack[tos--];
            vis[u[0]][u[1]] = true;
            for(int[] d:dir){   
                int dx = u[0] + d[0] , dy = u[1] + d[1];
                if(dx >= 0 && dx < m && dy >= 0 && dy < n && !vis[dx][dy] && image[dx][dy] == sp){
                    image[dx][dy] = color;
                    vis[dx][dy] = true;
                    stack[++tos] = new int[]{dx,dy};
                }
            }
        }
        return image;
    }
}