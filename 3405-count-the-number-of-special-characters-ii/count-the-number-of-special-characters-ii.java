class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] isUpper = new boolean[26];
        boolean[] isLower = new boolean[26];
        for(char ch:word.toCharArray()){
            if(Character.isUpperCase(ch)){
                    isUpper[Character.toLowerCase(ch)-'a'] = true;
            }else{
                if(!isUpper[ch-'a'])
                    isLower[ch-'a'] = true;
                else
                    isLower[ch-'a'] = false;
            }
        }
        int res = 0; 
        for(int i = 0 ; i < 26 ; ++i){
            res +=  isUpper[i] && isLower[i] ? 1 : 0;
        }
        return res;
    }
}