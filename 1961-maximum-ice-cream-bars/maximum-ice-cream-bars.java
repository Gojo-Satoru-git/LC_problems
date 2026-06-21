class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = Integer.MIN_VALUE;
        for(int n:costs){
            max = Math.max(max,n);
        }
        int[] freq = new int[max+1];
        for(int n:costs){
            freq[n]++;
        }
        int res = 0;
        for(int i = 0 ; i < freq.length ; ++i){
            if(coins >= i * freq[i]){
                coins -= (i * freq[i]);
                res += freq[i];
            }else{
                res += coins / i;
                break;
            }
        }
        return res;
    }
}