
class Solution {
    class Interval {
        int start, end;
        long weight;
        int id;

        Interval(int start, int end, long weight, int id) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.id = id;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(intervals.get(i).get(0), intervals.get(i).get(1), intervals.get(i).get(2), i);
        }

        // Sort chronologically by start time to process suffixes
        Arrays.sort(arr, (a, b) -> Integer.compare(a.start, b.start));

        // Precompute the index of the next non-overlapping interval
        int[] nextValid = new int[n];
        for (int i = 0; i < n; i++) {
            nextValid[i] = findFirst(arr, arr[i].end);
        }
        long[][] dpWeight = new long[5][n + 1];
        int[][] dpLen = new int[5][n + 1];
        int[][][] dpIndices = new int[5][n + 1][4];

        for (int i = n - 1; i >= 0; i--) {
            int next = nextValid[i];
            for (int k = 1; k <= 4; k++) {
                long w1 = dpWeight[k][i + 1];
                int len1 = dpLen[k][i + 1];
                long w2 = arr[i].weight + dpWeight[k - 1][next];
                int len2 = dpLen[k - 1][next] + 1;
                int[] cand2 = new int[len2];
                for (int j = 0; j < len2 - 1; j++) {
                    cand2[j] = dpIndices[k - 1][next][j];
                }
                cand2[len2 - 1] = arr[i].id;
                for (int j = 1; j < len2; j++) {
                    int key = cand2[j];
                    int p = j - 1;
                    while (p >= 0 && cand2[p] > key) {
                        cand2[p + 1] = cand2[p];
                        p--;
                    }
                    cand2[p + 1] = key;
                }
                if (w2 > w1) {
                    assign(dpWeight, dpLen, dpIndices, k, i, w2, len2, cand2);
                } else if (w1 > w2) {
                    assign(dpWeight, dpLen, dpIndices, k, i, w1, len1, dpIndices[k][i + 1]);
                } else {
                    boolean pick2 = false;
                    boolean decided = false;
                    for (int j = 0; j < Math.min(len2, len1); j++) {
                        if (cand2[j] < dpIndices[k][i + 1][j]) {
                            pick2 = true;
                            decided = true;
                            break;
                        } else if (cand2[j] > dpIndices[k][i + 1][j]) {
                            pick2 = false;
                            decided = true;
                            break;
                        }
                    }
                    if (!decided) {
                        pick2 = len2 < len1;
                    }

                    if (pick2) {
                        assign(dpWeight, dpLen, dpIndices, k, i, w2, len2, cand2);
                    } else {
                        assign(dpWeight, dpLen, dpIndices, k, i, w1, len1, dpIndices[k][i + 1]);
                    }
                }
            }
        }
        int finalLen = dpLen[4][0];
        int[] res = new int[finalLen];
        for (int j = 0; j < finalLen; j++) {
            res[j] = dpIndices[4][0][j];
        }
        return res;
    }

    private void assign(long[][] dpWeight, int[][] dpLen, int[][][] dpIndices, 
                        int k, int i, long weight, int len, int[] srcArray) {
        dpWeight[k][i] = weight;
        dpLen[k][i] = len;
        for (int j = 0; j < len; j++) {
            dpIndices[k][i][j] = srcArray[j];
        }
    }

    private int findFirst(Interval[] arr, int targetEnd) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].start > targetEnd) { 
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}