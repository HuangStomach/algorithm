// 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
class Solution {
    public boolean isPerfectSquare(int num) {
        int sumnum = 1;
        while (num > 0) {
            num -= sumnum;
            sumnum += 2;
        }
        return num == 0;
    }
}