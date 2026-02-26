class Solution {
    public int numSteps(String s) {
        StringBuilder str = new StringBuilder(s);
        int res = 0;
        while(str.length() != 1){
            if(str.charAt(str.length()-1) == '1'){
                int i = str.length()-1;
                while(i >= 0 && str.charAt(i) == '1'){
                    str.setCharAt(i,'0');
                    --i;
                }
                if(i < 0){
                    str = new StringBuilder("1").append(str);
                }else{
                    str.setCharAt(i,'1');
                }
            }else{
                str.deleteCharAt(str.length()-1);
            }
            ++res;
        }
        return res;
    }
}