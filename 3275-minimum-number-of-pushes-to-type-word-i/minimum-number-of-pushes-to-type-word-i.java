class Solution {
    public int minimumPushes(String word) {
        int buttons = 8;
        Integer[] freq = new Integer[26];
        Arrays.fill(freq,0);
        for(char ch:word.toCharArray()){
            freq[ch-'a'] += 1;
        }
        Arrays.sort(freq,(a,b)->(b-a));
        int res = 0;
        for(int i = 0 ; i <= 25 ; ++i){
            res = res + (i / 8 == 0 ? 1*freq[i] : (i / 8  == 1 ? 2 * freq[i] : (i / 8 == 2 ? 3 * freq[i] : 4 * freq[i])));
        }
        return res;
    }
}