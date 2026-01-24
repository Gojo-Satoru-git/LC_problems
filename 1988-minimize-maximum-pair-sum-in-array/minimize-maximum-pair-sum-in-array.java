class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int res = 0;
        int j = nums.length -1 ;
        while(i < j){
            res = Math.max(nums[i]+nums[j],res);
            ++i;
            --j;
        }
        return res;
    }
}