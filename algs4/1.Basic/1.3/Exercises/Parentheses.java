import edu.princeton.cs.algs4.*;

// 1.3.4
public class Parentheses {
    public static boolean couple(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.pop() != '{') return false;
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str;
        str = "[()]{}{[()()]()}";
        System.out.println(couple(str));
        str = "[(])";
        System.out.println(couple(str));
    }
}