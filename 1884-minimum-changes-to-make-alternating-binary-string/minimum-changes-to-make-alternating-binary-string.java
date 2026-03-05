class Solution {
    public int minOperations(String s) {
        int ct1 = 0;
        for(int i = 0 ; i < s.length()  ; ++i){
            if(i%2 == 0 && s.charAt(i) == '1')++ct1;
            else if(i % 2 == 1 && s.charAt(i) == '0')++ct1;
        }
        return Math.min(ct1,s.length() - ct1);
    }
}