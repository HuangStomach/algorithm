/**
 * 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str: tokens) {
            if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                stack.push(Integer.parseInt(str));
            }
            else {
                int a = stack.pop();
                int b = stack.pop();
                if (str.equals("+")) stack.push(b + a);
                else if (str.equals("-")) stack.push(b - a);
                else if (str.equals("*")) stack.push(b * a);
                else if (str.equals("/")) stack.push(b / a);
            }
        }
        return stack.pop();
    }
}
