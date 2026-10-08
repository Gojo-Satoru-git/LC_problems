class Solution {
    public String removeOuterParentheses(String s) {
        int ct = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch :s.toCharArray()){
            if(ch == '('){
                if(ct != 0)sb.append(ch);
            }else{
                if(ct != 1)sb.append(ch);
            }
            ct += (ch == '(' ? +1 : -1);
        }
        return sb.toString();
    }
}