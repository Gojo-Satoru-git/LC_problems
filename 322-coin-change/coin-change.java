class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = Integer.MAX_VALUE / 2;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int a = 1; a <= amount; a++) {
            if (a % coins[0] == 0) {
                dp[0][a] = a / coins[0];
            } else {
                dp[0][a] = INF;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int a = 1; a <= amount; a++) {
                int take = INF;
                if (a - coins[i] >= 0) {
                    take = 1 + dp[i][a - coins[i]];
                }
                int ntake = dp[i - 1][a];
                dp[i][a] = Math.min(take, ntake);
            }
        }

        return dp[n - 1][amount] >= INF ? -1 : dp[n - 1][amount];
    }
}
