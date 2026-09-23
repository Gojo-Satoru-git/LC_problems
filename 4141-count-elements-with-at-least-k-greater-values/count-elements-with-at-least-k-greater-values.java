class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        if(k == 0)return n;
        for(int i = 0 ; i < n - k ; ++i){
            int num = nums[i];
            int firstGreater = -1;
            int low = i , high = n - 1;
            while(low <= high){
                int mid = low + (high - low)/2;
                if(nums[mid] > num){
                    firstGreater = mid;
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            if(firstGreater != -1 && n - firstGreater >= k)++res;
        }
        return res;
    }
}