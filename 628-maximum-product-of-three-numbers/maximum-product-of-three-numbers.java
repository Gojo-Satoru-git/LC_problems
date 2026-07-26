class Solution {
    public int maximumProduct(int[] nums) {
        int min[] = new int[2];
        int max[] = new int[3];
        Arrays.fill(min,Integer.MAX_VALUE);
        Arrays.fill(max,Integer.MIN_VALUE);
        for(int i = 0 ; i < nums.length; ++i){
            if(nums[i] > max[0]){
                max[2] = max[1];
                max[1] = max[0];
                max[0] = nums[i];
            }else if(nums[i] > max[1]){
                max[2] = max[1];
                max[1] = nums[i];
            }else if(nums[i] > max[2]){
                max[2] = nums[i];
            } 
            if(nums[i] < min[0]){
                min[1] = min[0];
                min[0] = nums[i];
            }else if(nums[i] < min[1]){
                min[1] = nums[i];
            }
            
        }
        return Math.max(max[0]*max[1]*max[2],min[0]*min[1]*max[0]);
    }
}