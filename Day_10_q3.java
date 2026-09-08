//Valid Parenthesis
//If open parenthesis, push it in stack
//If close parenthesis, pop the stack
 import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // If stack is empty, no matching opening bracket
                if (stack.isEmpty()) return false;

                char top = stack.peek();
                if ((top == '(' && c == ')') ||
                    (top == '[' && c == ']') ||
                    (top == '{' && c == '}')) {
                    stack.pop(); // matched pair
                } else {
                    return false; // mismatch
                }
            }
        }

        // Valid only if stack is empty at the end
        return stack.isEmpty();
    }
}
