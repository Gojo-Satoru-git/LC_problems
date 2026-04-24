class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lct = 0  , rct =  0 ;
        for(char ch : moves.toCharArray()){
            if(ch == 'L'){
                ++lct;
            }else if(ch == 'R'){
                ++rct;
            }
        }
        int fill = lct >= rct ? -1 : +1;
        int res = 0 ;
        for(char ch : moves.toCharArray()){
            if(ch == 'L'){
                --res;
            }else if(ch == 'R'){
                ++res;
            }else{
                res += fill;
            }
        }
        return Math.abs(res);
    }
}