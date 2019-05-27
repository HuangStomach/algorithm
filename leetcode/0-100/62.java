/**
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int line = 0; line < m; line++) dp[line][0] = 1;
        for (int col = 0; col < n; col++) dp[0][col] = 1;
        for (int line = 1; line < m; line++) {
            for (int col = 1; col < n; col++) dp[line][col] = dp[line - 1][col] + dp[line][col - 1];
        }
        return dp[m - 1][n - 1];
    }
}