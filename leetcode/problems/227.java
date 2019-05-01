/**
 * 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 */
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        s = s + "+0";
        Stack<String> nums = new Stack<>();
        Stack<String> ops = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;

            String str = Character.toString(c);
            if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                sb.append(str);
                continue;
            }
            
            nums.push(sb.toString());
            sb.setLength(0);
            if (ops.size() > 0) {
                if (ops.peek().equals("*")) {
                    ops.pop();
                    int value = Integer.parseInt(nums.pop()) * Integer.parseInt(nums.pop());
                    nums.push(Integer.toString(value));
                }
                else if (ops.peek().equals("/")) {
                    ops.pop();
                    int a = Integer.parseInt(nums.pop());
                    int b = Integer.parseInt(nums.pop());
                    int value = b / a;
                    nums.push(Integer.toString(value));
                }
                else if (ops.peek().equals("-")) {
                    nums.push("-" + nums.pop());
                }
            }
            ops.push(str);
        }
        nums.push(sb.toString());

        int res = 0;
        while (nums.size() > 0) {
            res += Integer.parseInt(nums.pop());
        }
        return res;
    }
}