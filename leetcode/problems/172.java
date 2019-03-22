// 给定一个整数 n，返回 n! 结果尾数中零的数量。
class Solution {
    public int trailingZeroes(int n) {
        int num = 0;
        while (n / 5 != 0) {
            num += n / 5;
            n /= 5;
        }
        return num;
    }
}