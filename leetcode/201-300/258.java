/**
 * 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 */
class Solution {
    public int addDigits(int num) {
        if (num < 9) return num;
        num %= 9;
        if (num == 0) return 9;
        return num;
    }
}