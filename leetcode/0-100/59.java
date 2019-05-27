/**
 * 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int c = 1;
        int j = 0;

        while (c <= n * n) {
            for (int i = j; i < n - j; i++) arr[j][i] = c++;
            for (int i = j + 1; i < n - j; i++) arr[i][n - j - 1] = c++;
            for (int i = n - j - 2; i >= j; i--) arr[n - j - 1][i] = c++;
            for (int i = n - j - 2; i > j; i--) arr[i][j] = c++;
            j++;
        }

        return arr;
    }
}