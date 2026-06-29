class Solution {
    List<List<Integer>> res ;
    boolean[] took;
    private void backtrack(int[] nums , List<Integer> curr){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
        }
        //System.out.println(curr);
        for(int i = 0 ; i < nums.length  ;++i){
           if(!took[i]){ 
                curr.add(nums[i]);
                took[i] = true;
                //System.out.println(curr);
                backtrack(nums,curr);
                curr.remove(curr.size()-1);
                took[i] = false;
           }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        took = new boolean[nums.length];
        backtrack(nums,new ArrayList<>());
        return res;
    }
}