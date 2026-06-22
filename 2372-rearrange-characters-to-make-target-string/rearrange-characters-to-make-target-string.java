class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] target_freq = new int[26];
        int[] freq = new int[26];
        for(char ch:target.toCharArray()){
            target_freq[ch-'a']++;
        }
        for(char ch:s.toCharArray()){
            freq[ch - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for(char ch:target.toCharArray()){
            res = Math.min(res,freq[ch-'a']/target_freq[ch-'a']);
        }
        return res;
    }
}