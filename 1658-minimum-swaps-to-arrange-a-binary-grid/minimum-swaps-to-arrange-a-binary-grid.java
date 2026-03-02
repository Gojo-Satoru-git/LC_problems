class Solution {
    public int minSwaps(int[][] grid) {
        int[] zerosFromRight = new int[grid.length];
        int zeroCount = 0;
        int n = grid.length;
        int res = 0 ;
        for(int i  = 0 ; i < n ; ++i){
            for(int j = n - 1 ; j >= 0 && grid[i][j] != 1 ; --j){
                zerosFromRight[i]++;
                ++zeroCount;
            }
        }
        if(zeroCount < (n*(n-1))/2)return -1;
        for(int i = 0 ; i  < n ;  ++i){
            int req = n - i - 1;
            int j = i;
            while(j < n && zerosFromRight[j] < req){
               ++j; 
            }
            if (j == n) return -1;
            while (j > i) { 
                int temp = zerosFromRight[j]; 
                zerosFromRight[j] = zerosFromRight[j - 1]; 
                zerosFromRight[j - 1] = temp; res++; j--; 
            }
        }
        return res;



    }
}