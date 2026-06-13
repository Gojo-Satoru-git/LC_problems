class Solution {
    int idx;
    int[] order;
    int[] inDegree;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        idx = 0;
        order = new int[numCourses];
        inDegree = new int[numCourses];
        int ct = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; ++i){
            adj.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < numCourses ; ++i){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int u = q.poll();
            ++ct;
            order[idx++] = u;
            for(int v:adj.get(u)){
                inDegree[v]--;
                if(inDegree[v] == 0)q.offer(v);
            }
        }
        return ct == numCourses ? order : new int[0];
    }
}