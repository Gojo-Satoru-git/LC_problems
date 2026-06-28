class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        int res = 1; 
        for (int i = 0; i < arr.length; i++) {
            cnt[Math.min(n, arr[i])]++; 
        }
        for (int i = 2; i < cnt.length; i++) {
            res = Math.min(i, res + cnt[i]);
        }
        return res; 
    }
}