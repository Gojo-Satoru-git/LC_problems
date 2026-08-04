class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int n:nums){
            max = Math.max(max,n);
            min = Math.min(min,n);
        }
        boolean[] hash = new boolean[max-min+1];
        for(int n:nums){
            hash[n-min] = true;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i <= max-min; ++i){
            if(!hash[i])res.add(i + min);
        }
        return res;
    }
}