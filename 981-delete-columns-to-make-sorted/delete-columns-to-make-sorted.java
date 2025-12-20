class Solution {
    public int minDeletionSize(String[] str) {
        int n = str.length;
        int m = str[0].length();
        int res =0 ;
        for(int i = 0 ; i < m ; ++i){
            for(int j = 1 ; j < n; ++j){
                if(str[j].charAt(i) < str[j-1].charAt(i)){
                    ++res;
                    break;
                }
            }
        }
        return res;
    }
}