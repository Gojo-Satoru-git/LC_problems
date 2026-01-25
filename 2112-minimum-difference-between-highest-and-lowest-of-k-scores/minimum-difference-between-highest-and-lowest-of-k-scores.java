class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0 , j = k - 1;
        int res = 100001;
        if(k == 1)return 0;
        while(j < nums.length){
            res = Math.min(nums[j]-nums[i],res);
            ++i;
            ++j;
        }
        return res;
    }
}