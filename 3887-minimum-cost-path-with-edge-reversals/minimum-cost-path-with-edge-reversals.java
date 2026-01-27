class Solution {
    public int minCost(int n, int[][] edges) {
        Map<Integer, ArrayList<int[]>> adjList = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, 2 * w});
        }

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0];
            int d = edge[1];

            if (u == n - 1) return dist[n - 1];
            if (visited[u]) continue;
            visited[u] = true;

            if (!adjList.containsKey(u)) continue;

            for (int[] neighbour : adjList.get(u)) {
                int v = neighbour[0];
                int w = neighbour[1];
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        return -1;
    }
}
