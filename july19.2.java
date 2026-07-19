class Solution {
    public String removeDuplicates(String chars) {
        if(chars.length() == 1)
            return chars;

        Stack<Character> st = new Stack<>();

        for(char ch : chars.toCharArray()) {
            if(st.isEmpty() || st.peek() != ch) {
                st.push(ch);
            } else {
                st.pop();
            }
        }

        String res = "";

        while(!st.isEmpty()) {
            res = st.pop() + res;
        }

        return res;
    }
}
