class Solution {
    public int minimumDeletions(String s) {
        int totalA = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') totalA++;
        }
        int minDel = totalA; 
        int bCount = 0;      
        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                bCount++;   
            } else { 
                totalA--;   
            }
            minDel = Math.min(minDel, bCount + totalA);
        }
        return minDel;
    }
}