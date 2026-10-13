class Solution {
    public long maxAlternatingSum(int[] nums) {
        long res = 0;
        int n  = nums.length;
        Long[] arr = new Long[n];
        for(int i = 0 ; i < n ; ++i){
            arr[i] = 1L * nums[i] * nums[i];
        }
        Arrays.sort(arr, (x, y) ->
            Long.compare(x,y)
        );
        for(int i = 0 ; i < n/2 ; ++i){
            res -= arr[i];
        }
        for(int i = n/2 ; i < n ; ++i){
            res += arr[i];
        }
        return res;
    }
}