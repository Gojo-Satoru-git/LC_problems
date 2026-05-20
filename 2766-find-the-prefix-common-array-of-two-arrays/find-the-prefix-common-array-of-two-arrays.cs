public class Solution {
    public int[] FindThePrefixCommonArray(int[] A, int[] B) {
        int n = A.Length;
        double[] hash = new double[n+1];
        int[] C = new int[n];
        for(int i = 0 ; i < n ; ++i){
            hash[A[i]] += 0.5;
            hash[B[i]] += 0.5;
            C[i] = (int)hash[A[i]] + (A[i] != B[i]? (int)hash[B[i]] :  0) + (i != 0 ? C[i-1] : 0); 
        }
        return C;
    }
}