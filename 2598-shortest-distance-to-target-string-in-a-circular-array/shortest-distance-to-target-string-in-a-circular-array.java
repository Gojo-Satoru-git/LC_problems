class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        for (int step = 0; step < n; step++) {
            int forward = (startIndex + step) % n;
            int backward = (startIndex - step + n) % n;
            if (words[forward].equals(target) || words[backward].equals(target)) {
                return step;
            }
        }
        return -1;
    }
}