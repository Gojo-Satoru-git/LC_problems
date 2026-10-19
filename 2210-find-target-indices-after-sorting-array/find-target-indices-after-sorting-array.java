class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        int start = -1;
        Arrays.sort(nums);
        int low = 0 , high = nums.length - 1;
        while( low <= high ){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                start = mid;
                high = mid - 1;
            }else if(nums[mid] > target){
                high = mid  - 1;
            }else{
                low = mid + 1;
            }
        }
        if(start == -1)return res;
        while(start < nums.length && nums[start] == target){
            res.add(start++);
        }
        return res;
    }
}