class Solution {
    private int f(int i, int t, int[] coins , int[][] dp){
        if(i == coins.length)return Integer.MAX_VALUE/2;
        if(t == 0) return 0;
        if(dp[i][t] != -1)return dp[i][t];
        int take = Integer.MAX_VALUE/2;
        if(t - coins[i] >= 0){
           take = 1 + f(i,t-coins[i],coins,dp); 
        }
        int ntake = f(i+1,t,coins,dp);
        return dp[i][t] = Math.min(take,ntake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length ;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n ; ++i){
            Arrays.fill(dp[i],-1);
        }
        int res = f(0,amount,coins,dp);
        return res == Integer.MAX_VALUE/2?-1:res;
    }
}