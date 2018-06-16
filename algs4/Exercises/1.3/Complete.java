import edu.princeton.cs.algs4.*;

// 1.3.9
public class Complete {
    public static void main(String[] args) {
        String str = "1+2)*3-4)*5-6)))";
        Stack<String> ops = new Stack<String>();
        Stack<String> num = new Stack<String>();
        
        for (int i = 0; i < str.length(); i++) {
            String value = String.valueOf(str.charAt(i));
            if ("+-*/".indexOf(value) >= 0) {
                ops.push(value);
            }
            else if (value.equals(")")) {
                String contact = ")" + num.pop() + ops.pop() + num.pop() + "(";
                num.push(contact);
            }
            else {
                num.push(value);
            }
        }
        String result = num.pop();
        System.out.println(result);

        // 更改逆序为顺序
        StringBuilder sb = new StringBuilder();
        for (int i = result.length() - 1; i >= 0; i--){
            sb.append(result.charAt(i));
        }
        System.out.println(sb);
    }
}