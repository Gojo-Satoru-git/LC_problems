class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] groups = new int[n];
        int group = 0;
        groups[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                group++;
            }
            groups[i] = group;
        }
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            answer[i] = groups[u] == groups[v];
        }
        return answer;
    }
}