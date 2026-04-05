class Solution {
    public boolean judgeCircle(String moves) {
        int i = 0  ,  j =  0 ;
        for(char ch : moves.toCharArray()){
            switch(ch){
                case 'U':--i;break;
                case 'D':++i;break;
                case 'L':--j;break;
                case 'R':++j;break;
            }
        }
        return i == 0 && j == 0 ;
    }
}