class Solution {
    private int distinctChar(String s){
        Set<Character> set = new HashSet<>();
        for(char ch:s.toCharArray()){
            set.add(ch);
        }
        return set.size();
    }
    public String minWindow(String s, String t) {
        StringBuilder res = new StringBuilder();
        int[] freqt = new int[128];
        int[] freqs = new int[128];
        for(char ch:t.toCharArray()){
            freqt[ch]++;
        }
        int n = s.length();
        int m = distinctChar(t);
        int minWindow = Integer.MAX_VALUE;
        int left = 0;
        for(int right = 0 ; right < n ; ++right){
            char chs = s.charAt(right);
            freqs[chs]++;
            if(freqs[chs] == freqt[chs])--m;
            while(m == 0 && left <= right){
                 if(m == 0){
                    if(right - left + 1 < minWindow){
                        minWindow = right - left+1;
                        res.setLength(0);
                        res.append(s.substring(left,right+1));
                    }
                }
                char chl = s.charAt(left++);
                freqs[chl]--;
                if(freqs[chl] < freqt[chl])++m;
            }
        }
        return res.toString();
    }
}