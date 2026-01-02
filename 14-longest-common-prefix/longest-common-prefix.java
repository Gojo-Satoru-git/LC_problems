class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int minlen = Integer.MAX_VALUE;
        
        for (String str : strs) {
            minlen = Math.min(minlen, str.length());
        }
        if (minlen == 0) return res.toString();
        for (int i = 0; i < minlen; ++i) {
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}
