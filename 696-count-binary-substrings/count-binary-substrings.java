class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0 ;
        int n = s.length();
        for(int i = 1 ; i < n; ++i){
            if(s.charAt(i-1) != s.charAt(i)){
                int l = s.charAt(i-1) , r = s.charAt(i);
                int j = i-2 , k = i+1;
                ++res;
                while(j >= 0 && k < n && s.charAt(j) == l && s.charAt(k) == r){
                    //System.out.println(s.substring(j,k+1));
                    ++res;
                    ++k;
                    --j;
                }
            }
        }
        return res;
    }
}