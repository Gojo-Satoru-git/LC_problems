class Solution {
    class State {
        int r;
        int c;
        int cost;
        int dir;
        int turns;
        State(int r, int c, int cost, int dir, int turns) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.dir = dir;
            this.turns = turns;
        }
    }
    public int minCost(int[][] grid, int k) {
        int[][] dirs = {
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0}
        };
        PriorityQueue<State> pq =
            new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));
        int m = grid.length;
        int n = grid[0].length;
        int[][][][] dist = new int[m][n][4][k + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int d = 0; d < 4; ++d) {
                    Arrays.fill(dist[i][j][d], Integer.MAX_VALUE);
                }
            }
        }
        for (int d = 0; d < 4; ++d) {
            dist[0][0][d][0] = grid[0][0];
            pq.offer(new State(0, 0, grid[0][0], d, 0));
        }
        while (!pq.isEmpty()) {
            State cell = pq.poll();
            int r = cell.r;
            int c = cell.c;
            if (cell.cost != dist[r][c][cell.dir][cell.turns])continue;
            if (r == m - 1 && c == n - 1)return cell.cost;
            for (int i = 0; i < 4; ++i) {
                int dr = r + dirs[i][0];
                int dc = c + dirs[i][1];
                if (dr < 0 || dr >= m || dc < 0 || dc >= n) {
                    continue;
                }
                int newTurns = cell.turns;
                if (i != cell.dir) {
                    newTurns++;
                }
                if (newTurns > k) {
                    continue;
                }
                int newCost = cell.cost + grid[dr][dc];
                if (newCost < dist[dr][dc][i][newTurns]) {
                    dist[dr][dc][i][newTurns] = newCost;
                    pq.offer(new State(dr, dc, newCost, i, newTurns));
                }
            }
        }
        return -1;
    }
}