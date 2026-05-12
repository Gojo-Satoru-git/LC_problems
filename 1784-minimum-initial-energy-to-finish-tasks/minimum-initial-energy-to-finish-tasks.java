

class Solution {
    private boolean canFinish(int[][] tasks, int energy) {
        for (int[] t : tasks) {
            if (energy < t[1]) return false;
            energy -= t[0];
        }                 
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> Integer.compare((b[1] - b[0]), (a[1] - a[0])));

        int maxReq = 0;
        int actualEnergySum = 0;
        for (int[] t : tasks) {
            actualEnergySum += t[0];
            maxReq = Math.max(maxReq, t[1]);
        }
        int low = maxReq;                  
        int high = actualEnergySum + maxReq;    
        int res = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFinish(tasks, mid)) {
                res = mid;
                high = mid - 1;  
            } else {
                low = mid + 1; 
            }
        }
        return res;
    }
}
