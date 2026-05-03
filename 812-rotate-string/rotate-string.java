class Solution {
    public boolean rotateString(String s, String goal) {
        String ss = new String(s+s);
        return ss.contains(goal) && goal.length() == s.length();
    }
}