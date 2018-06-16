import edu.princeton.cs.algs4.*;

// 1.3.9
public class InfixToPostfix {
    public static void main(String[] args) {
        String str = "((1+2)*((3-4)*(5-6)))";

        Stack<String> ops = new Stack<String>();
        for (int i = 0; i < str.length(); i ++) {
            String s = String.valueOf(str.charAt(i));
            if ("+-*/".indexOf(s) >= 0) {
                String top = ops.peek();
                if (!ops.isEmpty() && !top.equals("(")) {
                    if ((top.equals("+") || top.equals("-")) && (s.equals("*") || s.equals("/"))) {
                        int size = ops.size();
                        for (int j = 0; j < size; j++) {
                            System.out.print(ops.pop());
                        }
                    }
                }
                ops.push(s);
            }
            else if (s.equals(")")) {
                String pop = ops.pop();
                while (!pop.equals("(")) {
                    System.out.print(pop);
                    pop = ops.pop();
                }
            }
            else if (s.equals("(")) {
                ops.push(s);
            }
            else {
                System.out.print(s);
            }
        }
        for (String s : ops) {
            System.out.print(s);
        }
    }
}