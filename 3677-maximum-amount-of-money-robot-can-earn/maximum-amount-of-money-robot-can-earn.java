class Solution {
    public int fun(int i, int j, int k, int[][] arr, int[][][] dp) {
        if (i < 0 || j < 0) return Integer.MIN_VALUE; 
        if (i == 0 && j == 0) {
            if (arr[0][0] < 0 && k > 0) return 0; 
            return arr[0][0];
        }
        if (dp[i][j][k] != Integer.MIN_VALUE) return dp[i][j][k];

        int value = arr[i][j];
        int best = Integer.MIN_VALUE;
        int left = fun(i, j - 1, k, arr, dp);
        int up = fun(i - 1, j, k, arr, dp);
        if (left != Integer.MIN_VALUE) best = Math.max(best, value + left);
        if (up != Integer.MIN_VALUE) best = Math.max(best, value + up);
        if (value < 0 && k > 0) {
            int leftSkip = fun(i, j - 1, k - 1, arr, dp);
            int upSkip = fun(i - 1, j, k - 1, arr, dp);
            if (leftSkip != Integer.MIN_VALUE) best = Math.max(best, leftSkip);
            if (upSkip != Integer.MIN_VALUE) best = Math.max(best, upSkip);
        }
        return dp[i][j][k] = best;
    }

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3]; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        return fun(m - 1, n - 1, 2, coins, dp); 
    }
}
