/**
 * 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
class Solution {
    int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int height = board.length;
        int width = board[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    if (board[i][j] == 'O') dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'O') board[i][j] = '#';

        int height = board.length;
        int width = board[0].length;

        boolean result = true;

        for (int[] direct : direction) {
            int x = i + direct[0];
            int y = j + direct[1];
            if (x < 0 || y < 0 || x >= height || y >= width) continue;
            if (board[x][y] == 'X' || board[x][y] == '#') continue;
            dfs(board, x, y);
        }
    }
}
