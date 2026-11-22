class Solution {
public:
    bool checkString(string s) {
        bool b_appeared = false;
        for(auto ch:s){
            b_appeared = ch == 'b' ? true : b_appeared;
            if(ch == 'a' && b_appeared)return false;
        }
        return true;
    }
};