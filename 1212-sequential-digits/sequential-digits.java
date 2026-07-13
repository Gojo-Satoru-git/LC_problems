class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String num = new String("123456789");
        List<Integer> res = new ArrayList<>();
        for(int len = (int)Math.floor(Math.log10(low)) + 1 ; len <= (int)Math.floor(Math.log10(high)) + 1  ; ++len){
            for(int i = 0 ; i <= num.length() - len ; ++i){
                int n = Integer.parseInt(num.substring(i,i+len));
                if(n >= low && n <= high){
                    res.add(n);
                }
            }
        }
        return res;
    }
}