class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean isAllOdd = true;
        for(int n : nums1){
            if(n % 2 == 0){
                isAllOdd = false;
                break;
            }
        }
        if(isAllOdd)return true;
        boolean isAllEve = true;
        for(int n : nums1){
            if(n % 2 != 0){
                isAllEve = false;
                break;
            }
        }
        if(isAllEve)return true;
        int firstOdd = -1;
        Arrays.sort(nums1);
        for(int n:nums1){
            if(n % 2 == 1 && firstOdd == -1){
                firstOdd = n;
            }else if(n % 2 == 0 && (firstOdd == -1 || n - firstOdd < 1))return false;
        }
        return true;
    }
}