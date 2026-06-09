class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long min = Integer.MAX_VALUE; 
        long max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; ++i){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        return (long)k * (max - min);
    }
}