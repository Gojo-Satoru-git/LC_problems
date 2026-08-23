class Solution {
    public boolean sumGame(String s) {

    char[] arr = s.toCharArray();
    int n = arr.length;
    int minTarget = 0;
    int minSum = 0;
    int maxTarget = 0;
    int maxSum = 0;
    boolean flag = true;
    for (int i = 0; i < n; i++) {
        if (arr[i] == '?') {
            // First player's turn
            if (flag && i < n / 2) {
                minTarget += 0;
                maxTarget += 9;
                flag = !flag;
            } else if (flag && i >= n / 2) {
                minSum += 9;
                maxSum += 0;
                flag = !flag;
            }
            // Second player's turn
            else if (!flag && i < n / 2) {
                minTarget += 9;
                maxTarget += 0;
                flag = !flag;
            } else {
                minSum += 0;
                maxSum += 9;
                flag = !flag;
            }
        } else {
            int digit = arr[i] - '0';
            if (i < n / 2) {
                minTarget += digit;
                maxTarget += digit;
            } else {
                minSum += digit;
                maxSum += digit;
            }
        }
    }
    if (minSum != minTarget)
        return true;

    if (maxSum != maxTarget)
        return true;
    return false;
}
}