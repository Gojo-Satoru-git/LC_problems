class Solution {
    public boolean checkString(String s) {
        boolean bAppeared = false;
        for(char ch:s.toCharArray()){
            if(ch == 'b')bAppeared = true;
            if(ch == 'a' && bAppeared)return false;
        }
        return true;

    }
}