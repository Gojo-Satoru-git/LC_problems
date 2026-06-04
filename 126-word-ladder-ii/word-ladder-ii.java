class Solution {
    List<List<String>> res = new ArrayList<>();
    Map<String,Integer> mp = new HashMap<>();
    String b;
    class Pair<T,K> {
        T st;
        K step;
        Pair(T st, K step){
            this.st = st;
            this.step = step;
        }
    }
    private void dfs(String word, List<String> seq, int level) {
        if (word.equals(b)) {
            List<String> path = new ArrayList<>(seq);
            Collections.reverse(path);
            res.add(path);
            return;
        }
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < wordChar.length; ++i) {
            char original = wordChar[i];
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                wordChar[i] = ch;
                String w = String.valueOf(wordChar);
                if (mp.containsKey(w) && mp.get(w) == level - 1) {
                    seq.add(w);
                    dfs(w, seq, mp.get(w));
                    seq.remove(seq.size() - 1);
                }
            }
            wordChar[i] = original;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        b = beginWord;
        Set<String> set = new HashSet<>(wordList);
        Queue<Pair<String,Integer>> q = new ArrayDeque<>();
        mp.clear();
        mp.put(beginWord, 1);
        q.offer(new Pair<>(beginWord, 1));
        set.remove(beginWord);
        while (!q.isEmpty()) {
            Pair<String,Integer> word = q.poll();
            char[] wordChar = word.st.toCharArray();
            for (int i = 0; i < wordChar.length; ++i) {
                char original = wordChar[i];
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    wordChar[i] = ch;
                    String w = String.valueOf(wordChar);
                    if (set.contains(w)) {
                        q.offer(new Pair<>(w, word.step + 1));
                        mp.put(w, word.step + 1);
                        set.remove(w);
                    }
                }
                wordChar[i] = original;
            }
        }
        if (!mp.containsKey(endWord))
            return new ArrayList<>();
        ArrayList<String> seq = new ArrayList<>();
        seq.add(endWord);
        dfs(endWord,seq, mp.get(endWord));
        return res;
    }
}