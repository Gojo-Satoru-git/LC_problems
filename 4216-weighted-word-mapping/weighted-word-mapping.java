class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();
        for(String w:words){
            int weg = 0;
            for(char ch:w.toCharArray()){
                weg = (weg + weights[ch - 'a'])%26;
            }
            res.append((char)('a' + (25 - weg)));
        }
        return res.toString();
    }
}