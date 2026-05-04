class Solution {
    private void reverse(int[] arr){
        for(int i = 0 , j = arr.length - 1 ; i < j ; ++i,--j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
    private void transpose(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
}

    public void rotate(int[][] matrix) {
        transpose(matrix);
        for(int i = 0 ; i < matrix.length ; ++i){
            reverse(matrix[i]);
        }
    }
}