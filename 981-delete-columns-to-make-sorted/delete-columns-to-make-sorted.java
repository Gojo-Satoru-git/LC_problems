class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length, res= 0;
        char[][] matrix = new char[m][];
        for (int i = 0; i < m; i++) {
            matrix[i] = strs[i].toCharArray();
        }
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                if (matrix[j][i] > matrix[j + 1][i]) {
                    ++res;
                    break;
                }
            }
        }
        return res;
    }
}