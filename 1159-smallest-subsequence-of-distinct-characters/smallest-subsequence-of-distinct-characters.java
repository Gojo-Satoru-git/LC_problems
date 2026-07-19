class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[27];
        int n = s.length();
        for(int i = 0 ; i < n ; ++i){
            char ch = s.charAt(i);
            int x = ch & 31;
            freq[x]++;
        }
        boolean[] seen = new boolean[27];
        char[] stack = new char[n];
        int tos = -1;
        for(int i = 0 ; i < n ; ++i){
            char ch = s.charAt(i);
            int x = ch & 31;
            freq[x]--;
            if(seen[x])continue;
            while(tos != -1 && stack[tos] > ch && freq[stack[tos] & 31] != 0){
                seen[stack[tos] & 31] = false;
                --tos;
            }
            stack[++tos] = ch;
            seen[x] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= tos; i++){
            sb.append(stack[i]);
        }

        return sb.toString();
    }
}