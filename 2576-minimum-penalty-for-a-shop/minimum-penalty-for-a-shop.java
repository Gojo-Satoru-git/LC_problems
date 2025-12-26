class Solution {
    public int bestClosingTime(String customers) {
        int profit = 0;
        int mxProfitSoFar = 0;
        int res = 0;
        for(int i = 0 ; i < customers.length() ; ++i){
            char ch = customers.charAt(i);
            if(ch == 'Y')++profit;
            else profit--;
            if(profit > mxProfitSoFar){
                mxProfitSoFar = profit;
                res = i+1;
            }
        }
        return res;
    }
}