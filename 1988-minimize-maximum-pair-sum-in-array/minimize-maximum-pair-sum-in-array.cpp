class Solution {
public:
    int minPairSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int i =0 ; 
        int j = nums.size()-1;
        int res = 0;
        while(i < j){
            res = max(nums[i]+nums[j],res);
            ++i;
            --j;
        }
        return res;
    }
};