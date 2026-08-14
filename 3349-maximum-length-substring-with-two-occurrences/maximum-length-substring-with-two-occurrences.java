class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int i = 0 , j = 0;
        int n = s.length();
        int max = 0;
        while(j < n){
            while(j < n && freq[s.charAt(j)-'a'] < 2){
                ++freq[s.charAt(j)-'a'];
                ++j;
            }
            max = Math.max(j-i,max);
            if(j == n)break;
            char ch = s.charAt(j);
            do{
                freq[s.charAt(i)-'a']--;
                ++i;
            }while(freq[s.charAt(i)-'a'] > 2);
        }
        return max;
    }
}