class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sum = 0 ;
        for(int i = 0 ; i < nums.length ; ++i){
            sum += nums[i];
        }
        int preSum = 0;
        int[] res = new int[nums.length]; 
        for(int i = 0 ; i < nums.length ; ++i){
            preSum += nums[i];
            res[i] = Math.abs(sum - preSum);
            sum -= nums[i];
        }
        return res;
    }
}