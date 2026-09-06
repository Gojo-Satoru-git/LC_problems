class Solution {
    private int f(int i,int j ,String s , String t,int[][] dp){
        if(j == t.length())return 1;
        if(i == s.length())return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int cnt = 0;
        if(s.charAt(i) == t.charAt(j)){
            cnt += f(i+1,j+1,s,t,dp);
            cnt += f(i+1,j,s,t,dp);
        }else{
            cnt = f(i+1,j,s,t,dp);
        }
        return dp[i][j] = cnt;
    }
    public int numDistinct(String s, String t) {
        int m = s.length() , n = t.length();
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; ++i){
            Arrays.fill(dp[i],-1);
        }
        return f(0,0,s,t,dp);

    }
}