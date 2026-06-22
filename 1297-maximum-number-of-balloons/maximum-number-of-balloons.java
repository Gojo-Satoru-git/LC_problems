class Solution {
    public int maxNumberOfBalloons(String text) {
        float[] freq = new float[26];
        String s = new String ("balloon");
        for(char ch:text.toCharArray()){
            if(ch == 'o' || ch == 'l')
                freq[ch - 'a'] += 0.5;
            else{
                freq[ch - 'a'] += 1;
            }
            
        }
        int res = Integer.MAX_VALUE;
        for(char ch:s.toCharArray()){
            res = Math.min((int)(freq[ch-'a']),res);
        }
        return res;


    }
}