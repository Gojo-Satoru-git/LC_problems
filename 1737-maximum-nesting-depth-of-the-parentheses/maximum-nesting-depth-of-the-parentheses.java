class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int res = 0;
        for(char ch:s.toCharArray()){
            if(ch == '(')++depth;
            else if(ch == ')')--depth;
            res = Math.max(res,depth);
        }
        return res;
    }
}