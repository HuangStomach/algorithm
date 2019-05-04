/**
 * 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 */
class Solution {
    public int getSum(int a, int b) {
        int result = a ^ b;
        int carry = (a & b) << 1;
 
        if (carry == 0) return result;
 
        return getSum(result,carry);
    }
}