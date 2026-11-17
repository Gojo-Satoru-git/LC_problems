class Solution {
    public String digitSum(String s, int k) {
        StringBuilder copy = new StringBuilder(s);
        while (copy.length() > k) {
            StringBuilder sb = new StringBuilder(copy);
            copy.setLength(0);
            int sum = 0;
            for (int i = 0; i < sb.length(); i++) {
                sum += sb.charAt(i) - '0';

                if ((i + 1) % k == 0) {
                    copy.append(sum);
                    sum = 0;
                }
            }
            if (sb.length() % k != 0) {
                copy.append(sum);
            }
        }
        return copy.toString();
    }
}