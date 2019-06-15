/**
 * 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m < 1) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[] cur = new int[n + 1];
        int pre = 0; // 相当于上一行的前一列的元素。
        for (int i = 1; i <= m; ++i) {
            pre = 0;
            for (int j = 1; j <= n; ++j) {
                int tmp = cur[j]; // 上一行的运算结果；
                if (matrix[i - 1][j - 1] == '1') {
                    cur[j] = 1 + Math.min(pre, Math.min(cur[j], cur[j - 1]));
                    max = Math.max(max, cur[j]);
                } else {
                    cur[j] = 0;
                }
                pre = tmp;
            }
        }
        return max * max;
    }
}
