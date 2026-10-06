class Solution {
    public int minAddToMakeValid(String s) {
        int res =0;
        int tos =0;
        for(char ch:s.toCharArray()){
            if(ch == '(')
                ++tos;
            else{
                if(tos == 0)++res;
                else --tos;
            }
        }
        return res + tos ;
    }
}