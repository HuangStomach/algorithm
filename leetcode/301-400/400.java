/**
 * 第N个数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 * 没太理解 不过是数学 暂且跳过
 */
class Solution {
    public int findNthDigit(int n) {
        long len = 1, base = 1;
        long m = n;
        while (m > 9 * base * len) {
            m -= 9 * base * len;
            len++;
            base *= 10;
        }
        int curNum = (int) (base + (m - 1) / len);
        return ((curNum + "").charAt((int) ((m - 1) % len)) - '0');
    }
}