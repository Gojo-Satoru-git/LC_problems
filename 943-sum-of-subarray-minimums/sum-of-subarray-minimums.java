class Solution {
    int mod = (int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] stack = new int[n];
        int tos;
        int[] LSE = new int[n], RSE = new int[n];
        tos = -1;
        for(int i = 0 ; i < n ; ++i){
            while(tos != -1 && arr[i] <= arr[stack[tos]]){ 
                --tos;
            }
            LSE[i] = tos == -1 ? -1 : stack[tos];
            stack[++tos] = i;
        }
        tos = -1;
        for(int i = n-1 ; i >= 0 ; --i){
            while(tos != -1 && arr[i] < arr[stack[tos]]){ 
                --tos;
            }
            RSE[i] = tos == -1 ? -1 : stack[tos];
            stack[++tos] = i;
        }
        long res = 0;
        for(int i = 0 ; i < n ; ++i){
            int left = LSE[i] == -1 ? i+1 : i - LSE[i];
            int right = RSE[i] == -1 ? n-i : RSE[i] - i;
            res = (res + (1L * left * right) * arr[i]) % mod;
        }
        return (int)res;  
    }
}
