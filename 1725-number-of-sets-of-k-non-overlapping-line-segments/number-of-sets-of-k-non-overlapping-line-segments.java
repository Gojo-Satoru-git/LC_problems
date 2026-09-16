class Solution {
    int MOD;
    private long f(int x,int n , int k,int start,long dp[][][]){
        //System.out.println(x+" "+n+" "+k);  
        if(k == 0)return 1;
        if(x == n)return 0;
        if(dp[x][k][start] != -1)return (int)dp[x][k][start];
        long count = 0;
        if(start == 1)
            count = (count + f(x,n,k-1,0,dp) + f(x+1,n,k,1,dp)) % MOD;
        else 
            count = (count + f(x+1,n,k,1,dp) + f(x+1,n,k,0,dp)) % MOD;
        return dp[x][k][start] = count;
    }
    public int numberOfSets(int n, int k) {
        long[][][] dp = new long[n][k+1][2];
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ;j < k + 1 ; ++j)
                Arrays.fill(dp[i][j],-1);
        }
        MOD = (int)1e9 + 7;
        return (int)f(0,n,k,0,dp);
    }
}