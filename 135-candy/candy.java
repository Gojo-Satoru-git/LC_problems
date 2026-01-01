class Solution {
    public int candy(int[] ratings) {
       int n  = ratings.length;
       int i = 1 ;
       int sum = 1;
       while(i < n ){
            if(ratings[i] == ratings[i-1]){
                ++sum;
                ++i;
                continue; 
            }
            int peak = 1;
            while(i < n && ratings[i] > ratings[i-1]){
                ++peak;
                sum += peak; 
                ++i;
            }
            int valley = 1;
            while(i < n && ratings[i] < ratings[i-1]){
                sum += valley;
                ++valley;
                ++i;
            }
            if(valley > peak){
                sum += (valley-peak);
            }
       }
       return sum;
    }
}