class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int res = 0;
        int sum = 0;
        for(int i = 0 ; i < apple.length ; ++i){
            sum += apple[i];
        }
        int j = capacity.length -1;
        while(j >= 0 && sum >= 0){
            sum -= capacity[j];
            ++res;
            --j;
        }
        return sum + capacity[j+1] == 0 ? res - 1 :res;
    }
}