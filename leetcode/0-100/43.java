/**
 * 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        int l = l1 + l2; // 最大可能长度
        char[] ans = new char[l];

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        for (int i = l1 - 1; i >= 0; i--) {
            int c = c1[i] - '0';
            for (int j = l2 - 1; j >= 0; j--) {
                ans[i + j + 1] +=  c * (c2[j] - '0');
            }
        }

        for (int i = l - 1; i > 0; --i) {
            if (ans[i] > 9) {
                ans[i - 1] += ans[i] / 10;
                ans[i] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; ; i++) if (ans[i] != 0) break;
        for (; i < ans.length; i++) sb.append((char) (ans[i] + '0'));
        return sb.toString();
    }
}
