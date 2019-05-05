/**
 * x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1;
        int r = x > 46340 ? 46340 : x;
        // 二分查找，进行平方尝试，是否和x相当;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int res = mid * mid;
            if (res < x) l = mid + 1; 
            else if (res > x) r = mid - 1;
            else return mid;
        }
        return l - 1;
    }
}