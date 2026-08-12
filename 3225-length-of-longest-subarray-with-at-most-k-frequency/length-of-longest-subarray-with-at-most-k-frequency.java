class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        int i = 0 ;
        int j = 0;
        int res = 0;
        while(j < n){
            while(j < n && mp.getOrDefault(nums[j],0) < k){
                mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
                ++j;
            }
            //System.out.println(mp);
            res = Math.max(res,j-i);
            if(j == n)break;
            int x = nums[j];
            do{
                mp.put(nums[i],mp.getOrDefault(nums[i],0)-1);
                ++i;
            }while(mp.get(x) > k);
        }
        return res;

    }
}