class Solution {
    public String smallestSubsequence(String s) {
        // Track the last occurrence index of each character
        int[] lastIdx = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        
        // Track whether a character is already present in our stack
        boolean[] seen = new boolean[26];
        
        // Use a char array to simulate an optimized stack
        char[] stack = new char[26];
        int top = -1; 
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            
            // If the character is already in our result, skip it
            if (seen[idx]) {
                continue;
            }
            
            // Maintain monotonic increasing order where possible.
            // Pop the top element if it is lexicographically larger than 'c'
            // AND it appears again later in the string.
            while (top >= 0 && stack[top] > c && lastIdx[stack[top] - 'a'] > i) {
                seen[stack[top] - 'a'] = false;
                top--;
            }
            
            // Push the current character into our stack
            stack[++top] = c;
            seen[idx] = true;
        }
        
        // Convert the stack directly into the result string
        return new String(stack, 0, top + 1);
    }
}
