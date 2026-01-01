class Solution {
    public int candy(int[] ratings) {
       int n  = ratings.length;
       int[] cnd = new int[n];
       Arrays.fill(cnd,1);
       for(int i = 1 ; i < n ; ++i){
            if(ratings[i] > ratings[i-1]){
                cnd[i] = cnd[i-1]+1;
            }
            //System.out.print(cnd[i]+" ");
       }
       System.out.println();
       for(int i = n - 2 ; i >= 0 ;--i){
            if(ratings[i] > ratings[i+1] && cnd[i] <= cnd[i+1]){
                cnd[i] = cnd[i+1]+1;
            }
            //System.out.print(cnd[i]+" ");
       }
       int res = Arrays.stream(cnd).sum();
       return res;
    }
}