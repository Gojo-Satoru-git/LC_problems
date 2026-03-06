class Solution {
    public boolean checkOnesSegment(String s) {
        int seenZero = 0;
        for(int i = 0 ; i < s.length() ; ++i){
            if(s.charAt(i) == '0')seenZero = 1;
            if(s.charAt(i) == '1' && seenZero == 1)return false;
        }
        return true;
    }
}