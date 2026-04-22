class Solution {
    private int computeDiff(String s1 , String s2){
        int ct = 0 ; 
        for(int i  = 0 ; i < s1.length() ; ++i){
            if(s1.charAt(i) != s2.charAt(i))++ct;
        }
        return ct;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for(int i  = 0 ; i < queries.length ; ++i){
            for(int j = 0 ; j < dictionary.length ; ++j){
                if(computeDiff(queries[i],dictionary[j]) <= 2){
                    res.add(queries[i]);
                    break;
                }
            }
        }
        return res;
    }
}