class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int cntnve = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < m  ; ++i){
            for(int j = 0 ; j < n ; ++j){
                min = Math.min(min,Math.abs(matrix[i][j]));
                cntnve += (matrix[i][j] < 0 ? 1 : 0);
                res += Math.abs(matrix[i][j]);
            }
        }
        //System.out.println(min + " " + cntnve +  " " + res+ " ");
        return cntnve % 2 == 0 ? res : res - 2*min;
    }
}