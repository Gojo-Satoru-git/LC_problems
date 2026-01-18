class Solution {
    private boolean isValidMS(int[][] sqr,int i,int j,int k){
        int[] rSum = new int[k];
        int[] cSum = new int[k];
        int diaSum = 0;
        int antiDiaSum = 0;
        for(int x = i ; x < i + k ; ++x){
            for(int y = j ; y <j + k ; ++y){
                rSum[x-i] += sqr[x][y];
                cSum[y-j] += sqr[x][y];
                if(x-i == y-j) diaSum += sqr[x][y];
                if(x-i + y - j == k - 1) antiDiaSum += sqr[x][y];
            }
        }
        int sum = diaSum;
        for(int x = 0 ; x < k ;++x){
            if(rSum[x] != sum)return false;
            if(cSum[x] != sum)return false;
        }
        if(sum != antiDiaSum) return false;
        return true;
    }
    public int largestMagicSquare(int[][] grid) {
        int res = 0 ;
        int m = grid.length;
        int n = grid[0].length;
        int k = Math.min(m,n);
        for(int x = k ;  x >= 2 ; --x ){
            for(int i  = 0 ; i + x - 1 < m ; ++i){
                for(int j = 0 ; j + x - 1 < n ; ++j){
                    if(isValidMS(grid,i,j,x))return x;
                }
            }
        }
        return 1;
    }
}