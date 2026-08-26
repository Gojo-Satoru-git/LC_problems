class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        int n = s.length();
        int len = n + 1;
        for (int i = 0; i < n; i++) {
            int ct = 0;
            for (int j = i; j < n; j++) {
                ct += (s.charAt(j) - '0');
                if (ct == k) {
                    int currLen = j - i + 1;
                    String substr = s.substring(i, j + 1);
                    if (currLen < len || (currLen == len && substr.compareTo(res) < 0)) {
                        len = currLen;
                        res = substr;
                    }
                    break;
                }
            }
        }
        return res;
    }
}
