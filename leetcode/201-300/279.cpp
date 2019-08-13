// 完全平方数
// 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

// Lagrange's Four Square theorem：每个正整数均可表示为4个整数（包括0）的平方和，所以只有四种可能结果，即[1,2,3,4]
// Legendre's three-square theorem：非4^a(8b+7)型的正整数都可以用三个整数的平方和表示，所以对于可以写成4^a(8b+7）类型的n，其结果只能为4

#include <math.h>

class Solution {
public:
    int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;
        for (int a = 0; a * a <= n; ++a) {
            int b = sqrt(n - a * a);
            if (a * a + b * b == n) {
                return !!a + !!b;
            }
        }
        return 3;
    }
};