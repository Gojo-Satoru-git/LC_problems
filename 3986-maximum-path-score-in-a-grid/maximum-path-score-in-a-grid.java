class Solution {
    private int f(int i, int j, int k, int[][] grid, int[][][] dp) {
        int m = grid.length, n = grid[0].length;
        if (i >= m || j >= n || k < 0) return Integer.MIN_VALUE;
        int cost = grid[i][j] == 0 ? 0 : 1;

        if (k < cost) return Integer.MIN_VALUE;
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }
        if (dp[i][j][k] != -1) return dp[i][j][k];
        int down = f(i + 1, j, k - cost, grid, dp);
        int right = f(i, j + 1, k - cost, grid, dp);
        int best = Math.max(down, right);
        if (best == Integer.MIN_VALUE) {
            return dp[i][j][k] = Integer.MIN_VALUE;
        }
        return dp[i][j][k] = grid[i][j] + best;
    }

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = f(0, 0, k, grid, dp);
        return ans < 0 ? -1 : ans;
    }
}