class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mp = new HashMap<Character, Character>() {{
                                                                                put(')', '(');
                                                                                put('}', '{');
                                                                                put(']', '[');
                                                                            }};
        char[] stack = new char[s.length()];
        int tos = -1;
        for(char ch:s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{')stack[++tos] = ch;
            else{
                //System.out.println("mid");
                if(tos == -1 || mp.get(ch) != stack[tos])return false;
                else --tos;
            }
        }
        //System.out.println("end");
        return tos == -1;
    }
}