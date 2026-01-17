class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int res =0;
        int n = grid.length;
        int[] maxC = new int[n];
        int[] maxR = new int[n];
        for(int i = 0 ; i < n ; ++i ){
            for(int  j  = 0 ; j < n ; ++j){
                maxR[i] = Math.max(maxR[i],grid[i][j]);
                maxC[j] = Math.max(maxC[j],grid[i][j]);
            }
        }
        for(int i = 0 ; i < n ; ++i ){
            for(int  j  = 0 ; j < n ; ++j){
               int canBeIncreased = Math.min(maxR[i],maxC[j]);
               res += (canBeIncreased - grid[i][j]);
            }
        }
        return res;
        
    }
}