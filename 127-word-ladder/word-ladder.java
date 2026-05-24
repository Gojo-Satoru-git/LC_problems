class Solution {
    class Pair<T,K>{
        T word;
        K len;
        Pair(T word , K len){
            this.word = word;
            this.len = len;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<Pair<String,Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(beginWord,1));  

        while(!q.isEmpty()){
            Pair<String,Integer> p = q.poll();
            if(p.word.equals(endWord)) return p.len;

            char[] arr = p.word.toCharArray();   
            for(int i = 0 ; i < arr.length ; ++i){
                char original = arr[i];
                for(char ch = 'a' ; ch <= 'z' ; ++ch){
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        q.offer(new Pair<>(newWord, p.len+1));
                        set.remove(newWord);
                    }
                }
                arr[i] = original;   
            }
        }
        return 0;
    }
}
