class Solution {
    public boolean hasAlternatingBits(int n) {
        byte prev = (byte)(n % 2);
        n >>= 1;
        while(n != 0){
            byte curr = (byte)(n % 2);
            if(curr == prev)return false;
            prev = curr;
            n >>= 1;
        }
        return true;
    }
}