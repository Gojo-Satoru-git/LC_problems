class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        int noc = 0 ;
        for(int i = cost.length - 1  ; i >= 0 ; --i){
            ++noc;
            if(noc % 3 == 0)continue;
            res += cost[i];
        }
        return res;
    }
}