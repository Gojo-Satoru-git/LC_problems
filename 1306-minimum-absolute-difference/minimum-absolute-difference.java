class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int i = 0 , j = 1;
        while(j < arr.length){
            minDiff = Math.min(Math.abs(arr[j]-arr[i]),minDiff);
            ++i;
            ++j;
        }
        i = 0 ;
        j = 1 ;
        List<List<Integer>> res = new ArrayList<>();
        while(j < arr.length){
            if(Math.abs(arr[j] - arr[i]) == minDiff)res.add(new ArrayList<>(List.of(arr[i],arr[j])));
            ++i;
            ++j;
        }
        return res;

    }
}