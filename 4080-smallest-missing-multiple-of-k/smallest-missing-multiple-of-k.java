class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for(int n : nums){
            st.add(n);
        }
        int res = 0;
        for(int i = 1 ; i <= 101 ; ++i){
            int n = i*k;
            if(!st.contains(n)){
                res = n;
                break;
            }
        }
        return res;
    }
}