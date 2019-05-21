/**
 * Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */

class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
}
