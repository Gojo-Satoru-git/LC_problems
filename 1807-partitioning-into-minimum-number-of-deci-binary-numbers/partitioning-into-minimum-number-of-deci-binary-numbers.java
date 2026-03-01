class Solution {
    public int minPartitions(String n) {
        int res = 0;
        for(char ch:n.toCharArray()){
            int num = ch - '0';
            res = Math.max(num,res);
        }
        return res;
    }
}