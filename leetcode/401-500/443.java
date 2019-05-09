/**
 * 压缩字符串
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 */
class Solution {
    public int compress(char[] chars) {
        int x = 0;
        for (int i = 0; i < chars.length;) {
            int j = i;
            int k = 0;
            char c = chars[i];

            for (; j < chars.length; j++, k++) {
                if (chars[j] != c) break;
            }
            
            i += k;
            chars[x++] = c;
            if (k > 1) {
                for (char a : Integer.toString(k).toCharArray()) {
                    chars[x++] = a;
                }
            }
        }
        return x;
    }
}