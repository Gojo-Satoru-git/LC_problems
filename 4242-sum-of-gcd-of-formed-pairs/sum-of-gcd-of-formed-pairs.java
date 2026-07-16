class Solution {
    private int gcd(int a , int b){
        while(b != 0){
            int t = a % b ;
            a = b;
            b = t;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        long res = 0 ;
        int max = nums[0];
        int n = nums.length;
        int[] prefixGcd = new int[n];
        prefixGcd[0] = nums[0];
        for(int i = 1 ; i < n ;  ++i){
            max = Math.max(max,nums[i]);
            prefixGcd[i] = gcd(nums[i],max);
        }
        Arrays.sort(prefixGcd);
        int i = 0;
        int j = n-1;
        while(i < j){
            res += gcd(prefixGcd[i],prefixGcd[j]);
            ++i;
            --j;
        }
        return res;
    }
}