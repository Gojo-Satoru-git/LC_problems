class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1; 
        //int max = 0;
        int[] hash = new int[n+1];
        for(int e : nums){
            //max = Math.max(e,max);
            if(e > n){
                System.out.println("false1");
                return false;
            }
            hash[e]++;
        }
        System.out.println(Arrays.toString(hash));
        for(int i = 1 ; i < hash.length ; ++i){
            if(i == hash.length - 1 && hash[i] != 2){
                System.out.println("false2");
                return false;
            }
            if(i != hash.length - 1 && hash[i] != 1){
                System.out.println("false3");
                return false;
            }
        }
        return true;
    }
}