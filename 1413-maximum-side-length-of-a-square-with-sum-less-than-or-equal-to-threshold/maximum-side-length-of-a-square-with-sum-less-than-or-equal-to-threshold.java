class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m  = mat.length;
        int n = mat[0].length;
        long[][] rowPreSum  = new long[m][n+1];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPreSum[i][j + 1] = rowPreSum[i][j] + mat[i][j];
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j){
                int low = 1, high = Math.min(m - i, n - j);
                while(low <= high) {
                    int mid = low + (high - low) / 2;
                    int sum = 0;
                    for (int l = i; l < i + mid; ++l) {
                        sum += rowPreSum[l][j + mid] - rowPreSum[l][j];
                    }
                    if (sum <= threshold) {
                        res = Math.max(res, mid);
                        low = mid + 1;
                    } else {
                        high = mid - 1;           
                    }
                }
            }
        }
        return res;
    }
}
