class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1_000_000_007L;
        int[] bits = new int[31];
        long res = 0;
        for(int n:nums){
            for(int i = 0 ; i < 31 ; ++i){
                bits[i] += (n & (1L << i)) != 0 ? 1 : 0;
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
            res = (res + x * x) % mod; 
        }
        return (int)res;
    }
}