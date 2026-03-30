class Solution {
    private boolean isAnagram(char[] s1, char[] s2){
        int[] freq  = new int[26];
        for(int i = 0 ; i < s1.length ; ++i){
            ++freq[s1[i] - 'a'];
            --freq[s2[i] - 'a'];
        }
        for(int i = 0 ; i < 26 ; ++i){
            if(freq[i] != 0)return false;
        }
        return true;
    }
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        char[] strEve1 = new char[n % 2 == 0 ? n/2 : n/2+1];
        char[] strOdd1 = new char[n/2];
        char[] strEve2 = new char[n % 2 == 0 ? n/2 : n/2+1];
        char[] strOdd2 = new char[ n/2];
        //System.out.println(Arrays.toString(strEve1));
        int e = 0 , o = 0;
        for(int i = 0 ; i < n ; ++i){
            if(i % 2 == 0){
                strEve1[e] = s1.charAt(i);
                strEve2[e] = s2.charAt(i);
                ++e;
            }else{
                strOdd1[o] = s1.charAt(i);
                strOdd2[o] = s2.charAt(i);
                ++o;
            }
        }
        return isAnagram(strEve1,strEve2) && isAnagram(strOdd1,strOdd2);

    }
}