import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            }
            else {
                if (stack.size() == 0) return false;
                Character left = stack.pop();
                if ((left == '(' && c == ')')
                || (left == '[' && c == ']')
                || (left == '{' && c == '}')) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
