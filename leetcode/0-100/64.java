/**
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) grid[i][j] = grid[i][j] +  grid[i][j + 1];
                else if (j == grid[0].length - 1 && i != grid.length - 1) grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if (j != grid[0].length - 1 && i != grid.length - 1) grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }
}
