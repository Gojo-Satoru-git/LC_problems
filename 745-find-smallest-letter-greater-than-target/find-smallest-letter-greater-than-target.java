class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0 , high = letters.length-1;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(letters[mid] > target){
                //lowerBound
                int j = mid ;
                while(j > 0 && letters[j] == letters[j-1] )--j;
                ans = j;
                high = j - 1;
            }else{
                low = mid + 1;
            }
        }
        return letters[ans];
    }
}