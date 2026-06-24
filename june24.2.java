class Solution {
    public String removeDuplicates(String chars) {
        // If chars length is 1, all are identical so return the chars
        if (chars.length() == 1) return chars;

        // Create a stack object
        Stack<Character> s = new Stack<>();

        // Iterate through each character using for / for of loop
        for (char ch : chars.toCharArray()) {
            // If top element is not equal to current iterating character
            // Push the element
            if (s.isEmpty() || s.peek() != ch) {
                s.push(ch);
            } else {
                 // Else pop the character from the stack, it means identical characters found
                s.pop();
            }
           
        }
        
        
        // Initialize a result string to build the final answer
        // We build it in reverse since the stack pops elements in LIFO order
        String res = "";
        while (!s.isEmpty()) {
            res = s.pop() + res;
        }

        return res;
    }
}
