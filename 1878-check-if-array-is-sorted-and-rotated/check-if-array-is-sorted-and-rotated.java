class Solution {
    public boolean check(int[] nums) {
        int breakPoint = 0;
        int n = nums.length ;
        for(int i = 0 ; i < n  ; ++i){
            if(nums[i] > nums[(i+1)%n]){
                ++breakPoint;
            }
        }
        if(breakPoint <= 1)return true;
        return false;
    }
}