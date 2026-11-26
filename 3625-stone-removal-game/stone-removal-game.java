class Solution {
    public boolean canAliceWin(int n) {
        int n_copy = n;
        for(int i = 0 ; i <= n ; ++i){
            n_copy -= (10-i);
            if(n_copy < 0)return i % 2 != 0; // alice lose if even , else bob lose
        }
        return false;
    }
}