class Solution {
    int[] prefixSum;

    private int f(int idx, int m, int n, int[][] dp) {
        if (idx >= n) return 0;
        if (dp[idx][m] != -1)
            return dp[idx][m];
        int remaining = prefixSum[n - 1] - (idx > 0 ? prefixSum[idx - 1] : 0);
        int maxStones = 0;
        for (int i = 1; i <= 2 * m && idx + i <= n; ++i) {
            int opponent = f(idx + i,Math.max(m, i),n,dp);
            int current = remaining - opponent;
            maxStones = Math.max(maxStones, current);
        }
        return dp[idx][m] = maxStones;
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        prefixSum = new int[n];

        prefixSum[0] = piles[0];

        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return f(0, 1, n, dp);
    }
}