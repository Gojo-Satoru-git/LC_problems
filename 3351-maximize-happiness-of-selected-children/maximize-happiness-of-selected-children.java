class Solution {
    
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        Arrays.sort(happiness);
        for(int i = happiness.length - 1 ; i >= happiness.length - k ; --i){
            res = 1L * res  + ((happiness[i] - (happiness.length-1 - i)) >= 0 ? (happiness[i] - (happiness.length-1 - i)):0);
        }
        return res;
    }
}