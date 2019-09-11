// 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
#include <vector>

using std::vector;

class NumMatrix {
private:
    vector<vector<int>> dp;
public:
    NumMatrix(vector<vector<int>> &matrix) {
        int M = matrix.size();
        int N = M == 0 ? 0 : matrix[0].size();

        dp = vector<vector<int>>(M + 1, vector<int>(N + 1, 0));
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = dp[row2 + 1][col2 + 1];
        ans -= dp[row1][col2 + 1];
        ans -= dp[row2 + 1][col1];
        ans += dp[row1][col1];
        return ans;
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */