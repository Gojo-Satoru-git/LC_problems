class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[27];
        for(char ch:s.toCharArray()){
            freq[ch & 31]++;
        }
        boolean[] seen = new boolean[27];
        char[] stack = new char[s.length()];
        int tos = -1;
        for(char ch:s.toCharArray()){
            freq[ch & 31]--;
            if(seen[ch & 31])continue;
            while(tos != -1 && stack[tos] > ch && freq[stack[tos] & 31] != 0){
                seen[stack[tos] & 31] = false;
                --tos;
            }
            stack[++tos] = ch;
            seen[ch & 31] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= tos; i++){
            sb.append(stack[i]);
        }

        return sb.toString();
    }
}