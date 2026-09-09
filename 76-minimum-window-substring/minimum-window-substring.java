class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        int[] freqt = new int[128];
        int[] freqs = new int[128];
        int m = 0;
        for(char ch:t.toCharArray()){
            if(freqt[ch] == 0)++m;
            freqt[ch]++;
        }
        int n = s.length();
        int minWindow = Integer.MAX_VALUE;
        int left = 0;
        for(int right = 0 ; right < n ; ++right){
            char chs = s.charAt(right);
            freqs[chs]++;
            if(freqs[chs] == freqt[chs])--m;
            while(m == 0 && left <= right){
                if(right - left + 1 < minWindow){
                    minWindow = right - left+1;
                    res = s.substring(left,right+1);
                }
                char chl = s.charAt(left++);
                freqs[chl]--;
                if(freqs[chl] < freqt[chl])++m;
            }
        }
        return res;
    }
}