class Solution {
    String sol="";
    int cnt = 0;
    private void f(int i, int k, int n,StringBuilder current){
        if(!sol.isEmpty())return;
        if(i == n){
            ++cnt;
            if(cnt == k)sol = current.toString();
            return;
        }
        for(char ch = 'a' ; ch <= 'c' ; ++ch){
            if( current.length() == 0 || ch != current.charAt(current.length()-1)){
                current.append(ch);
                f(i+1,k,n,current);
                current.deleteCharAt(current.length()-1);
            }
        }
    }
    public String getHappyString(int n, int k) {
        f(0,k,n,new StringBuilder(""));
        return sol;
    }
}