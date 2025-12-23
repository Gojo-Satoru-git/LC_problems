class Solution {

    private int f(int i, int k, int[][] events, int[][] dp) {
        if (i == events.length || k == 0) return 0;
        if (dp[i][k] != -1) return dp[i][k];
        int npick = f(i + 1, k, events, dp);
        int next = findNext(i, events);
        int pick = events[i][2] + f(next, k - 1, events, dp);

        return dp[i][k] = Math.max(pick, npick);
    }
    private int findNext(int i, int[][] events) {
        int lo = i + 1, hi = events.length - 1;
        int ans = events.length;
        int end = events[i][1];

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (events[mid][0] > end) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); 

        int[][] dp = new int[events.length][3];
        for (int i = 0; i < events.length; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return f(0, 2, events, dp);
    }
}
