class Solution {
    public long maxAlternatingSum(int[] nums) {
        long res = 0;
        int n  = nums.length;
        Integer[] arr = new Integer[n];
        for(int i = 0 ; i < n ; ++i){
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (x, y) ->
            Integer.compare(Math.abs(x),Math.abs(y))
        );
        for(int i = 0 ; i < n/2 ; ++i){
            res -= 1L * arr[i] * arr[i];
        }
        for(int i = n/2 ; i < n ; ++i){
            res += 1L * arr[i] * arr[i];
        }
        return res;
    }
}