class Solution {
    private boolean isMagicSquare(int row, int col, int[][] grid) {
        if (row + 2 >= grid.length || col + 2 >= grid[0].length) return false;
        int[] r = new int[3];
        int[] c = new int[3];
        int[] d = new int[2];
        int[] seen = new int[11];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int val = grid[row + i][col + j];
                if(val<1 || val > 9||seen[val] == 1)return false;
                seen[val] = 1;
                r[i] += val;
                c[j] += val;
                if (i == j) d[0] += val;        
                if (i + j == 2) d[1] += val;       
            }
        }
        int s = r[0];
        for (int i = 0; i < 3; ++i) {
            if (r[i] != s || c[i] != s) return false;
        }
        if (d[0] != s || d[1] != s) return false;

        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 0; i <= grid.length - 3; ++i) {
            for (int j = 0; j <= grid[0].length - 3; ++j) {
                if (isMagicSquare(i, j, grid)) ++res;
            }
        }
        return res;
    }
}