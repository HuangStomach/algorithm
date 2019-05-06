/**
 * 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int num = 0;
        int length = Math.max(a.length(), b.length());
        if (length == 0) return "0";

        for (int i = 1; i <= length; i++) {
            if (a.length() - i >= 0) num += a.charAt(a.length() - i) - '0';
            if (b.length() - i >= 0) num += b.charAt(b.length() - i) - '0';
            sb.insert(0, num % 2);
            num /= 2;
        }
        if (num > 0) sb.insert(0, num);
        return sb.toString();
    }
}