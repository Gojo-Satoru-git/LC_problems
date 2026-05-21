class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer>  hash = new HashSet<>();
        int res = 0;
        for(int e : arr1){
            while(e != 0){
                hash.add(e);
                e /= 10;
            }
        }
        for(int e: arr2){
            while(e != 0){
                if((int)Math.floor(Math.log10(e))+1  <= res )break;
                if(hash.contains(e)){
                    res = (int)Math.floor(Math.log10(e))+1;
                }
                e /= 10;

            }
        }
        return res;

    }
}