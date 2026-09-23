class Solution {
    public int countElements(int[] nums, int k) {
        if(nums == null) return -1;
        if (k <= 0) return nums.length;
        Arrays.sort(nums);
        int i = nums.length - k;
        while(i >0&& nums[i - 1] == nums[i])
                --i;
        return i;
    }
}