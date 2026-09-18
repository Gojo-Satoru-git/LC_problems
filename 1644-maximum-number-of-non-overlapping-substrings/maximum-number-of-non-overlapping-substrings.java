class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';

            if (first[x] == -1)
                first[x] = i;

            last[x] = i;
        }
        List<Pair> intervals = new ArrayList<>();
        boolean[] seen = new boolean[26];
        for (int idx = 0; idx < s.length(); idx++) {
            int x = s.charAt(idx) - 'a';
            if (seen[x])
                continue;
            seen[x] = true;
            int i = first[x];
            int j = last[x];
            boolean valid = true;
            for (int k = i; k <= j; k++) {
                int c = s.charAt(k) - 'a';
                if (first[c] < i) {
                    valid = false;
                    break;
                }
                j = Math.max(j, last[c]);
            }

            if (valid)
                intervals.add(new Pair(i, j));
        }
        Collections.sort(intervals, (a, b) -> {
            if (a.j != b.j)
                return Integer.compare(a.j, b.j);

            return Integer.compare(a.j - a.i, b.j - b.i);
        });
        List<String> res = new ArrayList<>();
        int end = -1;
        for (Pair index : intervals) {
            if (end >= index.i)
                continue;

            res.add(s.substring(index.i, index.j + 1));
            end = index.j;
        }

        return res;
    }
}