class ProductOfNumbers {
public:
    vector<long long> prefixMul{1};
    ProductOfNumbers() {
    }
    void add(int num) {
        if(num == 0) prefixMul = {1};
        else prefixMul.push_back(num * prefixMul.back());
    }
    
    int getProduct(int k) {
        if(prefixMul.size() <= k)return 0;
        int n = prefixMul.size();
        return prefixMul[n-1] / prefixMul[n-k-1];
    }
};

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers* obj = new ProductOfNumbers();
 * obj->add(num);
 * int param_2 = obj->getProduct(k);
 */