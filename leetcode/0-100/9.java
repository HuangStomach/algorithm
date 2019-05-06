/**
 * 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int y = 0;
        int z = x;
        while (z > 0) {
            y = y * 10 + z % 10 ;
            z /= 10;
        }
        return y == x;
    }
}