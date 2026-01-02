class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] freq = new int[10001];
        //int res = 0;
        for(int i =0 ; i < nums.length ; ++i){
            freq[nums[i]]++;
            if(freq[nums[i]] == nums.length/2)return nums[i];
        }
        return -1;
    }
}