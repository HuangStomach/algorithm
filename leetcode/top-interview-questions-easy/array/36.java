import java.util.HashMap;

// 36
class Solution {
    public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> row = new HashSet<>();
			HashSet<Character> column = new HashSet<>();
			HashSet<Character> cube = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				// 检查第i行，在横坐标位置
				if (board[i][j] != '.' && !row.add(board[i][j])) return false;
				// 检查第i列，在纵坐标位置
				if (board[j][i] != '.' && !column.add(board[j][i])) return false;
				// 行号+偏移量
				int RowIndex = 3 * (i / 3) + j / 3;
				// 列号+偏移量
				int ColIndex = 3 * (i % 3) + j % 3;
				//每个小九宫格，总共9个
				if (board[RowIndex][ColIndex] != '.' && !cube.add(board[RowIndex][ColIndex]))
					return false;
			}
		}
        return true;
    }
}