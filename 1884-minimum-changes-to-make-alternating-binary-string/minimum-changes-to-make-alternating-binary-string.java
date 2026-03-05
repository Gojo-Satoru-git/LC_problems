class Solution {
    public int minOperations(String s) {
        int ct = 0;
        for(int i = 0 ; i < s.length()  ; ++i){
            char exp = i % 2 == 0 ? '1' : '0';
            if(exp == s.charAt(i))++ct;
        }
        return Math.min(ct,s.length() - ct);
    }
}