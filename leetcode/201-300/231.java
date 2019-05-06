/**
 * 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        // & 与运算
        // 因为2的幂次方二进制 首位均为1 其余均为0
        // 所以 -1 就会得到首位为0 其余均为1
        // 进行 & 运算 则全部不同全部为0
        return (n & (n - 1)) == 0;
    }
}