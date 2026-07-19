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
    public int makeConnected(int n, int[][] connections) {
        int extraEdges = 0;
        DisjointSet ds = new DisjointSet(n);
        for(int[] con:connections){
            int a = con[0];
            int b = con[1];
            if(ds.findUParent(a) != ds.findUParent(b)){
               ds.unionBySize(a,b);
            }else{
                extraEdges++;
            }
        }
        int components = 0;
        for(int i = 0 ; i < n ; ++i){
            if(ds.parent[i] == i)++components;
        }
        System.out.println(components);
        return extraEdges >= components - 1 ? components - 1 : -1;
    }
}