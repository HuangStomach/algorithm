/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
class Solution {
    boolean[][] visit;
    int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0) return false;
        if (word.length() == 0) return true;

        int col = board[0].length;
        if (row * col < word.length()) return false;

        visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(i, j, board, word, 1)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, String word, int key) {
        if (key == word.length()) return true;

        visit[i][j] = true;
        int row = board.length;
        int col = board[0].length;

        for (int[] direct : direction) {
            int x = i + direct[0];
            int y = j + direct[1];
            if (x < 0 || y < 0 || x >= row || y >= col || visit[x][y]) continue;
            if (board[x][y] == word.charAt(key) && dfs(x, y, board, word, key + 1)) return true;
            else continue;
        }

        visit[i][j] = false;
        return false;
    }
}