class Solution {
    public int maxJumps(int[] arr, int d) {
        int res = 0;
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        for(int i = 0 ; i < n ; ++i){
            res = Math.max(res,dfs(arr,i,d,dp));
        }
        return res;
    }
    private int dfs(int[] arr , int i , int d , int[] dp){
        if(dp[i] != -1)return dp[i];
        int n  = arr.length;
        int maxFromHere = 1;
        for(int j = i+1 ; j <= i + d  && j < n; ++j){
            if(arr[j] >= arr[i])break;
            maxFromHere = Math.max(maxFromHere,1+dfs(arr,j,d,dp));
        }
        for(int j = i - 1 ;  j >= i - d && j >= 0 ; --j){
            if(arr[j] >= arr[i])break;
            maxFromHere = Math.max(maxFromHere,1+dfs(arr,j,d,dp));
        }
        return dp[i] = maxFromHere;
    }
}