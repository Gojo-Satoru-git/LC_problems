class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();
        for(int i = 0 ; i < nums.length ; ++i){
            mp.computeIfAbsent(nums[i],k -> (new ArrayList<>())).add(i);
        }
        int res = Integer.MAX_VALUE;
        for(ArrayList<Integer> k : mp.values()){
            for(int i = 0 ; i < k.size() - 2 ; ++i){
                int d1 = k.get(i) , d2 = k.get(i+1) , d3 = k.get(i+2);
                res = Math.min(res,(d2 - d1) + (d3 - d2) + (d3 - d1));
                //System.out.println(d1+" "+d2+" "+" "+d3);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}