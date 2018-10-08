import edu.princeton.cs.algs4.*;

// 1.3.11
public class EvaluatePostfix {
    public static void main(String[] args) {
        String str = "12+34-56-**";
        Stack<Double> stack = new Stack<Double>();
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if ("+-*/".indexOf(s) >= 0) {
                double v1 = stack.pop();
                double v2 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(v1 + v2);
                        break;
                    case "-":
                        stack.push(v1 - v2);
                        break;
                    case "*":
                        stack.push(v1 * v2);
                        break;
                    case "/":
                        stack.push(v1 / v2);
                        break;
                }
            }
            else {
                stack.push(Double.parseDouble(s));
            }
        }

        System.out.println(stack.pop());
    }
}