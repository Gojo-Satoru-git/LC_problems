class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        double[] arr = new double[n+1];
        int C[] = new int[n];
        for(int i = 0 ; i < n ; ++i){
            arr[A[i]] += 0.5;
            arr[B[i]] += 0.5;
            C[i] = (int)arr[A[i]] + (A[i] != B[i] ? (int)arr[B[i]]: 0) + (i > 0 ? C[i-1] : 0);
        }
        return C;
    }
}