import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int depth = findMaxDepth(graph, n);
        if (depth == 0) return 0;
        return modPow(2, depth - 1);
    }
    private int findMaxDepth(List<List<Integer>> graph, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(new int[]{1, 0});
        visited[1] = true;
        int maxDepth = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int depth = curr[1];

            maxDepth = Math.max(maxDepth, depth);

            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(new int[]{nei, depth + 1});
                }
            }
        }
        return maxDepth;
    }
    private int modPow(long base, int exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return (int) result;
    }
}