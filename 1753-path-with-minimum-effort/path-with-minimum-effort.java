class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; ++i) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); 
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int e = cell[0], x = cell[1], y = cell[2];
            if (x == m-1 && y == n-1) return e;
            for (int[] d : dirs) {
                int dx = x + d[0], dy = y + d[1];
                if (dx >= 0 && dx < m && dy >= 0 && dy < n) {
                    int newEffort = Math.max(e, Math.abs(heights[x][y] - heights[dx][dy]));
                    if (newEffort < dist[dx][dy]) {
                        dist[dx][dy] = newEffort;
                        pq.offer(new int[]{newEffort, dx, dy});
                    }
                }
            }
        }
        return -1; 
    }
}
