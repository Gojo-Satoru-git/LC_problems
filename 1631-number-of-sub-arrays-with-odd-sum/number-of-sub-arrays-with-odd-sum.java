class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;

        long res = 0;
        int evenCount = 1; 
        int oddCount = 0;

        int prefixParity = 0;

        for (int num : arr) {
            prefixParity ^= num & 1;

            if (prefixParity == 1) {
                res = (res + evenCount) % mod;
                oddCount++;
            } else {
                res = (res + oddCount) % mod;
                evenCount++;
            }
        }

        return (int) res;
    }
}