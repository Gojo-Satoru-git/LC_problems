class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for(int n:nums){
            int cnt = 0;
            int sum = 0;
            for(int i = 1 ; i <= (int)Math.sqrt(n) && cnt <= 4 ; ++i){
                if(n % i == 0){
                    int j =  n / i;
                    if(i == j){
                        ++cnt;
                        sum += i;
                    }else{
                        cnt += 2;
                        sum += (i+j);
                    }
                }
                
            }
            if(cnt == 4){
                    res += sum;
            }
        }
        return res;  
    }
}