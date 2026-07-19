class DisjointSet{
    int[] parent , size ;

    DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size,1);
        for(int i = 0 ; i < n ; ++i){
            parent[i] = i;
        }
    }
    public int findUParent(int u){
        if(u == parent[u])return u;
        return parent[u] = findUParent(parent[u]);
    }
    public void unionBySize(int u , int v){
        int pu = findUParent(u);
        int pv = findUParent(v);
        if(pu == pv)return ;
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
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DisjointSet ds = new DisjointSet(n);
        HashMap<Integer,Integer> row = new HashMap<>();
        HashMap<Integer,Integer> col = new HashMap<>();
        for(int i = 0 ; i < n ; ++i){
            int[] s = stones[i];
            int x = s[0] , y = s[1];
            if(!row.containsKey(x)){
                row.put(x,i);
            }else{
                ds.unionBySize(i,row.get(x));
            }
            if(!col.containsKey(y)){
                col.put(y,i);
            }else{
                ds.unionBySize(i,col.get(y));
            }
        }
        int components = 0;
        for(int i = 0; i < n ; ++i){
            if(i == ds.parent[i])++components;
        }
        return n - components;
    }
}