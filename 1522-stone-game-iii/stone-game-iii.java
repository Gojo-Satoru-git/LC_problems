class Solution {
    private int f(int idx , int[] stoneValue , int[] dp){
        int n = stoneValue.length;
        if(idx >= n)return 0;
        if(dp[idx] != -1)return dp[idx];
        int one = stoneValue[idx] - f(idx+1,stoneValue,dp);
        int two = stoneValue[idx] + (idx + 1 < n ? stoneValue[idx+1] : 0)  - f(idx + 2,stoneValue , dp);
        int three = stoneValue[idx] + (idx + 1 < n ? stoneValue[idx+1] : 0) + (idx + 2 < n ? stoneValue[idx+2]:0) - f(idx + 3,stoneValue , dp);
        return dp[idx] = Math.max(one,Math.max(two,three));
    }
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp,-1);
        int diff = f(0,stoneValue,dp);
        return diff > 0 ? "Alice" : (diff == 0 ? "Tie" : "Bob");
    }
}