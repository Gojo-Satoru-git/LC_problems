class Solution {
    public int minAddToMakeValid(String s) {
        int res =0;
        int tos = -1;
        char[] stack = new char[s.length()];
        for(char ch:s.toCharArray()){
            if(ch == '(')
                stack[++tos] = ch;
            else{
                if(tos == -1)++res;
                else --tos;
            }
        }
        return res + tos + 1;
    }
}