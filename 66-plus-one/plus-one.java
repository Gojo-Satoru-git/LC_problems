class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1] != 9){
            digits[n-1]++;
            return digits;
        }
        int i = n-1;
        while(i >= 0 && digits[i] == 9){
            --i;
        }
        int res[] = new int[n+1];
        if(i >=0){
            digits[i]++;
            ++i;
            for(int x = i ; x < n ; ++x){
                digits[x] = 0;
            }
            return digits;
        }else{
            res[0] = 1;
        }
        return res;

    }
}