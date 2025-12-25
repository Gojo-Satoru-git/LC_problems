class Solution {
    
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        int n = happiness.length;
        Arrays.sort(happiness);
        for(int i = n - 1 ; i >= n - k ; --i){
            int happ = (happiness[i] - (n-1 - i));
            res =  res  + (happ >= 0 ? happ:0);
        }
        return res;
    }
}