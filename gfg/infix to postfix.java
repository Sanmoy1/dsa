import java.util.*;
class Solution {
    public static String infixToPostfix(String s) {
        String ans = "";
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Set precedence (higher number means higher precedence)
        map.put('(', 0);  // Lowest precedence
        map.put(')', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('^', 3);  // Highest precedence
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If operand, add to output
            if(Character.isLetterOrDigit(ch)) {
                ans += ch;
            }
            // If opening parenthesis, push to stack
            else if(ch == '(') {
                stack.push(ch);
            }
            // If closing parenthesis, pop until matching opening parenthesis
            else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    ans += stack.pop();
                }
                stack.pop();
            }
            // If operator
            else {
                // Pop operators with higher or equal precedence
                while(!stack.isEmpty() && stack.peek() != '(' && 
                      map.get(stack.peek()) >= map.get(ch)) {
                    ans += stack.pop();
                }
                stack.push(ch);  // Push current operator
            }
        }
        
        // Pop remaining operators
        while(!stack.isEmpty()) {
            if(stack.peek() == '(') {
                return "Invalid Expression";  // Unmatched opening parenthesis
            }
            ans += stack.pop();
        }
        
        return ans;
    }
}