class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int ct = 0;
        int res = Integer.MAX_VALUE;
        int n = words.length;
        for(int i = startIndex ; ct < n ; i = (i+1) % n , ++ct ){
            if(words[i].equals(target)){
                res = ct;
                break; 
            }
        }
        ct = 0;
        for(int i = startIndex ; ct < n  ; i = (i - 1 + n) % n , ++ct){
            if(words[i].equals(target)){
                res = Math.min(res,ct);
                break;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res ;
    }
}