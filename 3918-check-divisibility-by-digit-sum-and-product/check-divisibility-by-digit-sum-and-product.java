class Solution {
    public boolean checkDivisibility(int n) {
        int sumOfD = 0;
        int digitProd =  1;
        int num = n;
        while(num != 0){
            sumOfD += num % 10;
            digitProd *= num % 10;
            num /= 10;
        }
        return n % (sumOfD + digitProd) == 0 ;
    }
}