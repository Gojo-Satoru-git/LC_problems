class Solution {
    public String removeOuterParentheses(String s) {
        int ct = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch :s.toCharArray()){
            if(ch == '('){
                if(ct != 0)sb.append(ch);
                ++ct;
            }else{
                if(ct != 1)sb.append(ch);
                --ct;
            }
        }
        return sb.toString();
    }
}