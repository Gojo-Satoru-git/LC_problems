class Solution {
    public boolean canAliceWin(int n) {
        for(int i = 0 ; i <= 10 ; ++i){
            n -= (10-i);
            if(n < 0)return i % 2 != 0; // alice lose if even , else bob lose
        }
        return false;
    }
}