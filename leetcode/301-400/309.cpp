// 最佳买卖股票时机含冷冻期
// 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
#include <vector>

using std::vector;
using std::max;

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        if (prices.empty()) return 0;
        int n = prices.size();
        vector<int> sell(n, 0);
        vector<int> buy(n, 0);
        vector<int> cooldown(n, 0);
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            sell[i] = max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = max(buy[i - 1], cooldown[i - 1] - prices[i]);
            cooldown[i] = max(cooldown[i - 1], max(sell[i - 1], buy[i - 1]));
        }
        return sell.back();
    }
};