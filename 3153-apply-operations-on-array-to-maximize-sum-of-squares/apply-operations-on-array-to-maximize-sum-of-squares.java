class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1_000_000_007L;
        int[] bits = new int[31];
        long res = 0;
        for(int n:nums){
            for(int i = 0 ; i < 31 ; ++i){
                bits[i] += (n >> i & 1);
            }
        }
        while(k-- > 0){
            long x = 0;
            for(int i = 0; i < 31 ; ++i){
                if(bits[i] > 0){
                    x |= (1L << i);
                    --bits[i];
                }
            }
            res = (res + (x % mod * x % mod) % mod) % mod; 
        }
        return (int)res;
    }
}