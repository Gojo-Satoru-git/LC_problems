class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int ascents = 0, descents = 0;
        int ascentIdx = -1, descentIdx = -1;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            if (nums[i] > nums[next]) {
                descents++;
                descentIdx = next;
            } else {
                ascents++;
                ascentIdx = next;
            }
        }
        if (descents == 1) {
            return Math.min(descentIdx, n - descentIdx + 2);
        }
        if (ascents == 1) {
            return 1 + Math.min(ascentIdx, n - ascentIdx);
        }
        return -1;
    }
}