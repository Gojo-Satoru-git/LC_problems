class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int mod = (int)1e9+7;

        int[][] prefix = new int[n][3];
        prefix[0][0] = s.charAt(0) - '0';
        prefix[0][1] = (s.charAt(0) != '0' ? s.charAt(0) - '0' : 0);
        prefix[0][2] = (s.charAt(0) != '0' ? 1 : 0);

        long[] pow10 = new long[n+1];
        pow10[0] = 1;
        for (int i = 1; i <= n; ++i) {
            pow10[i] = (pow10[i-1] * 10) % mod;
        }

        for(int i = 1 ; i < n ; ++i){
            prefix[i][0] = prefix[i-1][0] + (s.charAt(i)-'0');
            prefix[i][2] = prefix[i-1][2] + (s.charAt(i) != '0' ? 1 : 0);
            if(s.charAt(i) != '0')
                prefix[i][1] = (int)((prefix[i-1][1] * 10L + (s.charAt(i)-'0')) % mod);
            else
                prefix[i][1] = prefix[i-1][1];
        }

        int[] res = new int[queries.length];
        int i = 0;
        for(int[] q:queries){
            int l = q[0], r = q[1];
            int sum = prefix[r][0] - (l != 0 ? prefix[l-1][0] : 0);
            long concat = prefix[r][1];
            int len = prefix[r][2] - (l != 0 ? prefix[l-1][2] : 0);
            if (l > 0) {
                concat = (concat - (prefix[l-1][1] * pow10[len]) % mod + mod) % mod;
            }
            long ans = 1L * sum * concat % mod;
            res[i++] = (int)ans; 
        }
        return res;
    }
}
