class ProductOfNumbers {
    ArrayList<Integer> prefix;
    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }
    public void add(int num) {
        if(num == 0){
            prefix = new ArrayList<>();
            prefix.add(1);
        }else{
            prefix.add(num * prefix.get(prefix.size() - 1));
        }
    }
    
    public int getProduct(int k) {
        if(prefix.size() <= k)return 0;
        int n = prefix.size();
        return prefix.get(n - 1) / prefix.get(n - k  - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */