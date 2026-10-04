class Solution {
    Boolean[][] memo;
    private boolean f(int i , int ct , String s){
        if(i == s.length()){
            return ct == 0;
        }
        if(ct < 0)return false;
        if(memo[i][ct] != null)return memo[i][ct]; 
        boolean left , right, next;
        left = right = next = false;

        if(s.charAt(i) == '*'){
            left = f(i+1,ct+1,s);
            right = f(i+1,ct-1,s);
        }
        next = f(i+1,ct + (s.charAt(i) == '(' ? 1 : (s.charAt(i) == ')' ? - 1 : 0)),s);
        return memo[i][ct] = left || right || next ; 
    }
    public boolean checkValidString(String s) {
        memo = new Boolean[s.length()][s.length()+1];
        return f(0,0,s);
    }
}