class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowOneCt = new int[m];
        int[] colOneCt = new int[n];
        for(int i = 0 ; i < m ; ++i){
            for(int j = 0 ; j < n ;++j){
                if(mat[i][j] == 1){
                    rowOneCt[i]++;
                    colOneCt[j]++;
                }
            }
        }
        int res = 0;
        for(int i = 0 ; i < m ; ++i){
            for(int j = 0 ; j < n ; ++j){
                if(mat[i][j] == 1 && rowOneCt[i] == 1 && colOneCt[j] == 1)++res;
            }
        }
        return res;
    }
}