class Solution {
    public boolean checkValidString(String s) {
        int star = 0;
        int n = 0;
        for(char ch:s.toCharArray()){
            if(ch == '*')++star;
            else if(ch == '(')++n;
            else --n;
            if(n+star < 0)return false;
        }
        n = 0;
        star = 0;
        for(int i = s.length() - 1 ; i >= 0; --i){
            char ch = s.charAt(i);
            if(ch == '*')++star;
            else if(ch == ')')++n;
            else --n;
            if(n+star < 0)return false;
        }
        return true;
        
    }
}