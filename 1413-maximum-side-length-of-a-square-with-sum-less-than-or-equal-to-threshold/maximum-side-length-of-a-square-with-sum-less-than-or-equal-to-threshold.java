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
            for (int j = 0; j < n; ++j) {
                int sum = 0;
                for (int k = 1; i + k <= m && j + k <= n; ++k) {
                    sum = 0;
                    for (int l = i; l < i + k; ++l) {
                        sum += rowPreSum[l][j + k] - rowPreSum[l][j];
                    }
                    if (sum <= threshold) {
                        res = Math.max(res, k);
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
