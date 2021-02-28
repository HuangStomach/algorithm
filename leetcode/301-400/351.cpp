// 安卓系统手势解锁
// 我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。
// 给你两个整数，分别为 m 和 n，其中 1 ≤ m ≤ n ≤ 9，那么请你统计一下有多少种解锁手势，是至少需要经过 m 个点，但是最多经过不超过 n 个点的。
#include <vector>

using std::vector;

class Solution {
private:
    vector<int> isUsed;

public:
    void numberOfPatterns(int num, int used, int m, int n, int &count) {
        if (used >= m) ++count;
        if (used >= n) return;
        for (int i = 1; i <= 9; ++i) {
            if (isUsed[i]) continue;
            if (i == num) continue;
            if (num % 2 == 0 && num + i == 10 && !isUsed[5]) continue;
            if (num % 2 == 1 && num != 5 && i != 5 && i % 2 == 1 && !isUsed[(i + num) / 2]) continue;
            isUsed[i] = 1;
            numberOfPatterns(i, used + 1, m, n, count);
            isUsed[i] = 0;
        }
    }

    int numberOfPatterns(int m, int n) {
        isUsed = vector<int>(10, 0);
        int count = 0, res = 0;
        isUsed[1] = 1;
        numberOfPatterns(1, 1, m, n, count);
        isUsed[1] = 0;
        isUsed[2] = 1;
        numberOfPatterns(2, 1, m, n, count);
        isUsed[2] = 0;
        res = count * 4;
        count = 0;
        isUsed[5] = 1;
        numberOfPatterns(5, 1, m, n, count);
        isUsed[5] = 0;
        res += count;
        return res;
    }
};