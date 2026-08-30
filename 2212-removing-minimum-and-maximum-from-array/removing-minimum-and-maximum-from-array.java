class Solution {
    public int minimumDeletions(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int n : nums){
            min = Math.min(min,n);
            max = Math.max(max,n);
        }
        int i = 0;
        int leftToRight = 0;
        int rightToLeft = 0;
        int fromBoth = 0;
        boolean minSeen = false, maxSeen = false;
        while(!minSeen || !maxSeen){
            if(nums[i] == min)minSeen = true;
            if(nums[i] == max)maxSeen = true;
            ++leftToRight;
            ++i;
        }
        i = nums.length - 1;
        minSeen = false;
        maxSeen = false;
        while(!minSeen || !maxSeen){
            if(nums[i] == min)minSeen = true;
            if(nums[i] == max)maxSeen = true;
            ++rightToLeft;
            --i;
        }
        i = 0 ;
        minSeen = false;
        maxSeen = false;
        while(!minSeen && !maxSeen){
            if(nums[i] == min)minSeen = true;
            if(nums[i] == max)maxSeen = true;
            ++fromBoth;
            ++i;
        }

        i = nums.length - 1;
        minSeen = false;
        maxSeen = false;
        while(!minSeen && !maxSeen){
            if(nums[i] == min)minSeen = true;
            if(nums[i] == max)maxSeen = true;
            ++fromBoth;
            --i;
        }
        return Math.min(rightToLeft,Math.min(leftToRight,fromBoth));
    }
}