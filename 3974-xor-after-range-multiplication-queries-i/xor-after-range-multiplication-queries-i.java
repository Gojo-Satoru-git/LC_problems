class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int idx = 0 ; 
        int mod = (int)1e9+7;
        for(int i = 0;  i < queries.length ; ++i){
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];
            idx = l ;
            while(idx <= r){
                long temp = nums[idx];
                nums[idx] = (int)((temp * v) % mod);
                idx += k;
            }
        }
        int res = 0;
        for(int n:nums){
            res ^= n;
        }
        return res;
    }
}