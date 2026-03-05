class Solution {
    public int minOperations(String s) {
        int ct1 = 0;
        for(int i = 0 ; i < s.length()  ; ++i){
            if(i%2 == 0 && s.charAt(i) == '1')++ct1;
            else if(i % 2 == 1 && s.charAt(i) == '0')++ct1;
        }
        int ct2 = 0;
        for(int i = 0 ; i < s.length() ; ++i){
            if(i%2 == 0 && s.charAt(i) == '0')++ct2;
            else if(i % 2 == 1 && s.charAt(i) == '1')++ct2;
        }  
        return Math.min(ct1,ct2);
    }
}