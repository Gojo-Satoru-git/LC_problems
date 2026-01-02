class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] hash = new int[256];
        Arrays.fill(hash,-1);
        for(int i = 0 ; i < s.length() ; ++i){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(hash[ch1 - '\0'] !=-1 && hash[ch1-'\0'] != (ch2 - '\0'))return false;
            else hash[ch1-'\0'] = ch2 - '\0';
        }Arrays.fill(hash,-1);
        for(int i = 0 ; i < s.length() ; ++i){
            char ch2 = s.charAt(i);
            char ch1 = t.charAt(i);
            if(hash[ch1 - '\0'] !=-1 && hash[ch1-'\0'] != (ch2 - '\0'))return false;
            else hash[ch1-'\0'] = ch2 - '\0';
        }
        return true;
    }
}