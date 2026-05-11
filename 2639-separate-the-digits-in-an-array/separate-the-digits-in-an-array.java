class Solution {
    public int[] separateDigits(int[] nums) {
         int totalSize = 0 ;
         for(int n : nums){
            totalSize += (Math.floor(Math.log10(n))+1);
         }
         int i = 0;
         int[] res = new int[totalSize];
         for(int n : nums){
            int nod = (int)Math.floor(Math.log10(n))+1;
            int checkpoint = nod;
            while(n != 0){
                res[i + nod-1] = n % 10;
                n /= 10;
                --nod;
            }
            i = i + checkpoint;
         }
         return res;
    }
}