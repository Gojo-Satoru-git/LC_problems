class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = words.length - 1 ; i > 0 ; --i){
            if(words[i].trim().length() != 0)
                res.append(words[i].trim()+" ");
        }
        res.append(words[0].trim());
        return res.toString();
    }
}