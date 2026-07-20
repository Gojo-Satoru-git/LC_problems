class DisjointSet{
    int[] parent , size ;
    DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size,1);
        for(int i  = 0 ; i < n ; ++i){
            parent[i] = i;
        }
    }
    public int findUParent(int u){
        if(u == parent[u])return u;
        return parent[u] = findUParent(parent[u]);
    }
    public void unionBySize(int u,int v){
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> mp = new HashMap<>();
        for(int i = 0 ; i < n ; ++i){
            int len = accounts.get(i).size();
            for(int j = 1 ; j < len ; ++j){
                String s = accounts.get(i).get(j);
                if(!mp.containsKey(s)){
                    mp.put(s,i);
                }else{
                    ds.unionBySize(mp.get(s),i);
                }
            }
        }
        List<List<String>> mergedMails = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            mergedMails.add(new LinkedList<>());  
        }
        for(Map.Entry<String,Integer> e:mp.entrySet()){
            int i = e.getValue();
            String mail = e.getKey();
            int pi = ds.findUParent(i);
            mergedMails.get(pi).add(mail);
        }
        for (int i = 0; i < n; ++i) {
            Collections.sort(mergedMails.get(i));
        }
        for(int i = 0 ; i < n ;  ++i){
            mergedMails.get(i).addFirst(accounts.get(i).get(0));
        }
        for(int i = n-1 ; i >= 0; --i)
        if(mergedMails.get(i).size() == 1){
                mergedMails.remove(i);
        }
        return mergedMails;


    }
}