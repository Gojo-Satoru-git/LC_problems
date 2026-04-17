class Solution {
    private int reverse(int n){
        
        int reversed = 0;
        while(n != 0){
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; ++i){
            
            if(map.containsKey(nums[i])){
               int d = i - map.get(nums[i]);
               res = Math.min(d,res); 
            }
            int r = reverse(nums[i]);
            map.put(r,i);
        }
        return  res == Integer.MAX_VALUE ? -1 : res ;
    }
    
}