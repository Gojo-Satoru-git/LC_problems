class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int oddIndex = -1;
        for(int i = 0 ; i < 26 ; ++i){
            if(freq[i]%2 != 0)oddIndex = i;
            sb.append(String.valueOf((char)('a'+i)).repeat(freq[i]/2));
        }
        if(oddIndex != -1)sb.append((char)('a'+oddIndex));
        for(int i = 25 ; i >= 0 ; --i){
            sb.append(String.valueOf((char)('a'+i)).repeat(freq[i]/2));
        }
        return sb.toString();
    }
}