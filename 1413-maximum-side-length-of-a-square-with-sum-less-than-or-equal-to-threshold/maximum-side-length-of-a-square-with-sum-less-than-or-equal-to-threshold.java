class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m+1][n+1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i-1][j-1] 
                          + pre[i-1][j] 
                          + pre[i][j-1] 
                          - pre[i-1][j-1];
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int low = 1, high = Math.min(m - i, n - j);
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    int x2 = i + mid, y2 = j + mid;
                    int sum = pre[x2][y2] - pre[i][y2] - pre[x2][j] + pre[i][j];
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
