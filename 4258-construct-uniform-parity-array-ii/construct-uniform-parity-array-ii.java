class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean hasOdd = false;
        for(int n:nums1){
            if((n & 1) == 1)hasOdd = true;
            min = Math.min(n,min);
        }
        if((min & 1) == 1)return true;
        return !hasOdd;
    }
}