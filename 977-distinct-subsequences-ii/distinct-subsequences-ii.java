class Solution {
    public int distinctSubseqII(String s) {
        int[] dp  = new int[26];
        int tot = 0;
        int MOD = (int)1e9 + 7;
        for(int  i = 0 ; i < s.length() ; ++i){
            int c = s.charAt(i) - 'a';
            int add = (tot - dp[c] + MOD) % MOD;
            dp[c] = 1 + tot;
            tot = (dp[c] + add) % MOD;
        } 
        return tot;  
    }
}