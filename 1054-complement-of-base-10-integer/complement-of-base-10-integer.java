class Solution {
    public int bitwiseComplement(int n) {
        int res =0;
        if(n == 0)return 1;
        for(int i = 0 ; n != 0 ; ++i){
            res += (((n & 1) == 1? 0:1) * ((int)Math.pow(2,i)));
            n >>= 1;
        }
        return res;
    }
}