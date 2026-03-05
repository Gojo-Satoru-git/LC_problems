class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int cnt0 = 0; 
        
        for (int i = 0; i < n; i++) {
            char expected = (i % 2 == 0 ? '0' : '1');
            if (s.charAt(i) != expected) {
                cnt0++;
            }
        }
        
        return Math.min(cnt0, n - cnt0);
    }
}