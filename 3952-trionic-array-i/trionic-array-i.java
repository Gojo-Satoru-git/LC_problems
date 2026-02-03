class Solution {
    public boolean isTrionic(int[] nums) {
        int i = 1;
        int n = nums.length;
        int j = i;
        while(i < n && nums[i] > nums[i-1])++i;
        if(i >= n || i-j == 0)return false;
        j = i;
        while(i < n && nums[i] < nums[i-1])++i;
        if(i >= n || i-j == 0)return false;
        while(i < n && nums[i] > nums[i-1])++i;
        if( i < n)return false;
        else return true;
    }
}