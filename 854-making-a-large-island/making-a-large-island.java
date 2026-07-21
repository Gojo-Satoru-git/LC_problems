class DisjointSet{
    int[] parent , size ;
    DisjointSet(int n){
        parent = new int[n+1];
        size = new int[n+1];
        Arrays.fill(size,1);
        for(int i = 1  ; i <= n ; ++i){
            parent[i] = i;
        }
    }
    public int findUParent(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = findUParent(parent[u]);
    }
    public void union(int u,int v){
        int pu = findUParent(u) , pv = findUParent(v);
        if(pu == pv)return;
        if(size[pu] < size[pv]){
            size[pv] += size[pu];
            parent[pu] = pv;
        }else{
            size[pu] += size[pv];
            parent[pv] = pu;
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int node = 0;
        for(int i =0 ; i < m ; ++i){
            for(int j = 0; j < n ; ++j){
                if(grid[i][j] == 1){
                    grid[i][j] = ++node;
                }
            }
        }
        if(node == m*n)return node;
        DisjointSet ds = new DisjointSet(node);
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i =0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] != 0)
                    for(int[] dir:dirs){
                        int dx = i + dir[0] , dy = j + dir[1];
                        if(dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] != 0){
                            ds.union(grid[dx][dy],grid[i][j]);
                        }
                    }
            }
        }
        int res = 0;
        for(int i =0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                int islandSize = 1;
                Set<Integer> st =new HashSet<>();
                if(grid[i][j] == 0)
                    for(int[] dir:dirs){
                        int dx = i + dir[0] , dy = j + dir[1];
                        if(dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] != 0){
                            int p = ds.findUParent(grid[dx][dy]);
                            if(st.contains(p))continue;
                            st.add(p);
                            islandSize += ds.size[p];
                        }
                    }
                res = Math.max(islandSize,res);
            }
        }
        return res;

    }
}