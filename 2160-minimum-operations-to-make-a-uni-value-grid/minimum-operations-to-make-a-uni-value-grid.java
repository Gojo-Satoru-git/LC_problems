class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int arr[] = new int[m * n];
        int z = 0;
        int remainder = grid[0][0] % x;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] % x != remainder) return -1;
                arr[z++] = grid[i][j] / x;
            }
        }
        Arrays.sort(arr);
        int med = arr[(m * n) / 2];
        int res = 0;
        for (int val : arr) {
            res += Math.abs(val - med);
        }
        return res;
    }
}
