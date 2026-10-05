class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int[] stack = new int[n / 2 + 1];
        int tos = 0;
        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {
                ++tos;           
                stack[tos] = 0;     
            } 
            else {
                int inside = stack[tos--];
                int score;
                if (inside == 0)
                    score = 1;
                else
                    score = 2 * inside; 
                stack[tos] += score;
            }
        }
        return stack[0];
    }
}