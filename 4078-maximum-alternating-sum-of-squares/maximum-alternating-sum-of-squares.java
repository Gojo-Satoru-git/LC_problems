class Solution {
    public long maxAlternatingSum(int[] nums) {
        long res = 0;
        Integer[] arr = Arrays.stream(nums)
                      .boxed()
                      .toArray(Integer[]::new);
        Arrays.sort(arr, (x, y) ->
            Long.compare(1L * x * x, 1L * y * y)
        );
        int n  = nums.length;
        for(int i = 0 ; i < n/2 ; ++i){
            res -= (arr[i] * arr[i]);
        }
        for(int i = n/2 ; i < n ; ++i){
            res += (arr[i] * arr[i]);
        }
        return res;
    }
}