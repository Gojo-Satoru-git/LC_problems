class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int score = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < num ; ++i){
            int d = sum >= 9 ? 9 : sum;
            //System.out.println(d);
            sum -= Math.min(9,sum);
            sb.append((char)('0'+d));
            score += d*d;
        }
        if(sum != 0)return "";
        return sb.toString();
    }
}