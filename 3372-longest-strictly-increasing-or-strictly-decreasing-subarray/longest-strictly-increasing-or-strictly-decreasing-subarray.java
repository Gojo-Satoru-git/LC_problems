class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1 , dec = 1;
        int maxInc = 1, maxDec = 1;
        for(int i = 1 ; i < nums.length ; ++i){
            inc = nums[i] > nums[i-1] ? inc + 1 : 1;
            dec = nums[i] < nums[i-1] ? dec + 1 : 1;
            maxInc = Math.max(maxInc,inc);
            maxDec = Math.max(maxDec,dec);
        }
        return Math.max(maxInc,maxDec);
    }
}